package com.example.springdatajpasample.manytoone.uni;

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

import com.example.springdatajpasample.manytoone.uni.PersonManyToOneUni;
import com.example.springdatajpasample.manytoone.uni.PhoneManyToOneUni;
import com.example.springdatajpasample.manytoone.uni.PhoneRepositoryManyToOneUni;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // not use memory db
@Slf4j
public class PhoneRepositoryManyToOneUniTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private PhoneRepositoryManyToOneUni repository;

	@Test
	public void testFindById() {
		PersonManyToOneUni personData = new PersonManyToOneUni();
		personData.setLastName("lastName");
		entityManager.persist(personData);

		PhoneManyToOneUni phoneData = new PhoneManyToOneUni("123-456-7890");
		phoneData.setPerson(personData);
		entityManager.persist(phoneData);

		Optional<PhoneManyToOneUni> phone = repository.findByNumber(phoneData.getNumber());

		if (phone.isPresent()) {
			PhoneManyToOneUni p = phone.get();
			log.debug("phone id {} number {}", p.getId(), p.getNumber());
			log.debug("person {}", p.getPerson().toString());
		} else {
			log.debug("No Data");
		}

	}
}