package com.example.springdatajpasample.onetomany.bi;

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
	private PersonRepositoryOneToManyBi repository;

	@Test
	public void testFindById() {
		PersonOneToManyBi person = new PersonOneToManyBi();
		person.setLastName("lastName");
		PhoneOneToManyBi phone1 = new PhoneOneToManyBi( "123-456-7890" );
		PhoneOneToManyBi phone2 = new PhoneOneToManyBi( "321-654-0987" );

		person.addPhone( phone1 );
		person.addPhone( phone2 );
		entityManager.persist( person );

		Optional<PersonOneToManyBi> optional = repository.findById(person.getId());

		if (optional.isPresent()) {
			PersonOneToManyBi p = optional.get();
			log.debug("person {}", p.toString());
			
			List<PhoneOneToManyBi> phones = p.getPhones();
			
			for(PhoneOneToManyBi phone : phones) {
				log.debug("phone {}", phone.toString());
			}
		} else {
			log.debug("No Data");
		}

	}
}