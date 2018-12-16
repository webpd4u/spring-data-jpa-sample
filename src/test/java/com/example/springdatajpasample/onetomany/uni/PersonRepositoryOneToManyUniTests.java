package com.example.springdatajpasample.onetomany.uni;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // not use memory db
@Slf4j
public class PersonRepositoryOneToManyUniTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PersonRepositoryOneToManyUni repository;

	@Test
	public void testFindById() {
		PersonOneToManyUni person = new PersonOneToManyUni();
		person.setLastName("lastName");
		PhoneOneToManyUni phone1 = new PhoneOneToManyUni( "123-456-7890" );
		PhoneOneToManyUni phone2 = new PhoneOneToManyUni( "321-654-0987" );

		person.getPhones().add( phone1 );
		person.getPhones().add( phone2 );
		entityManager.persist( person );

		Optional<PersonOneToManyUni> optional = repository.findById(person.getId());

		if (optional.isPresent()) {
			PersonOneToManyUni p = optional.get();
			List<PhoneOneToManyUni> phones = p.getPhones();
			
			for(PhoneOneToManyUni phone : phones) {
				log.debug("phone id {} number {}", phone.getId(), phone.getNumber());
			}
		} else {
			log.debug("No Data");
		}

	}
}