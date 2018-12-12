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

@Profile("OneToMany")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // not use memory db
@Slf4j
public class PersonRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PersonRepository repository;

	@Test
	public void testFindById() {
		Person person = new Person();
		Phone phone1 = new Phone( "123-456-7890" );
		Phone phone2 = new Phone( "321-654-0987" );

		person.getPhones().add( phone1 );
		person.getPhones().add( phone2 );
		entityManager.persist( person );

		Optional<Person> optional = repository.findById(person.getId());

		if (optional.isPresent()) {
			Person p = optional.get();
			List<Phone> phones = p.getPhones();
			
			for(Phone phone : phones) {
				log.debug("phone id {} number {}", phone.getId(), phone.getNumber());
			}
		} else {
			log.debug("No Data");
		}

	}
}