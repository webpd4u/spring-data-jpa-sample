package com.example.springdatajpasample.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springdatajpasample.manytoone.uni.PersonManyToOneUni;
import com.example.springdatajpasample.manytoone.uni.PersonRepositoryManyToOneUni;
import com.example.springdatajpasample.manytoone.uni.PhoneManyToOneUni;
import com.example.springdatajpasample.manytoone.uni.PhoneRepositoryManyToOneUni;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(PhoneRepositoryManyToOneUni repository,
			PersonRepositoryManyToOneUni personRepository) {
		return args -> {
			PersonManyToOneUni person = new PersonManyToOneUni();
			personRepository.save(person);

			PhoneManyToOneUni phone1 = new PhoneManyToOneUni("123-456-7890");
			phone1.setPerson(person);
			repository.save(phone1);
			
			PhoneManyToOneUni phone2 = new PhoneManyToOneUni("123-456-7891");
			phone2.setPerson(person);
			repository.save(phone2);
		};

	}

}
