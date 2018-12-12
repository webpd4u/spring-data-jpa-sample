package com.example.springdatajpasample.manytoone;

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

import com.example.springdatajpasample.manytoone.uni.Person;
import com.example.springdatajpasample.manytoone.uni.Phone;
import com.example.springdatajpasample.manytoone.uni.PhoneRepository;

import lombok.extern.slf4j.Slf4j;

@Profile("ManyToOne")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // not use memory db
@Slf4j
public class PhoneRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PhoneRepository repository;

	@Test
	public void testFindById() {
		Person personData = new Person();
		entityManager.persist(personData);

		Phone phoneData = new Phone("123-456-7890");
		phoneData.setPerson(personData);
		entityManager.persist(phoneData);

		Optional<Phone> phone = repository.findByNumber(phoneData.getNumber());

		if (phone.isPresent()) {
			Phone p = phone.get();
			log.debug("phone id {} number {}", p.getId(), p.getNumber());
		} else {
			log.debug("No Data");
		}

	}
}