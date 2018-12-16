package com.example.springdatajpasample.manytomany.uni;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // not use memory db
@Slf4j
public class PersonRepositoryManyoManyUniTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PersonRepositoryManyToManyUni repository;

	@Test
	public void testFindById() {
		PersonManyToManyUni person1 = new PersonManyToManyUni();
		PersonManyToManyUni person2 = new PersonManyToManyUni();

		AddressManyToManyUni address1 = new AddressManyToManyUni("12th Avenue", "12A");
		AddressManyToManyUni address2 = new AddressManyToManyUni("18th Avenue", "18B");

		person1.getAddresses().add(address1);
		person1.getAddresses().add(address2);

		person2.getAddresses().add(address1);

		entityManager.persist(person1);
		entityManager.persist(person2);

		Optional<PersonManyToManyUni> optional = repository.findById(person1.getId());

		if (optional.isPresent()) {
			PersonManyToManyUni person = optional.get();
			List<AddressManyToManyUni> addresses = person.getAddresses();
			log.debug("person {}", person.toString());
			
			for(AddressManyToManyUni address : addresses) {
				log.debug("address {}", address.toString());
			}
		} else {
			log.debug("No Data");
		}

	}
}