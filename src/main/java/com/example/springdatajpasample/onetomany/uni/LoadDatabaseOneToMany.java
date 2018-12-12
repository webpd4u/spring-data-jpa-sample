package com.example.springdatajpasample.onetomany.uni;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;

@Profile("OneToMany")
@Configuration
@Slf4j
class LoadDatabaseOneToMany {

	@Bean
	CommandLineRunner initDatabase(PersonRepository repository, PhoneRepository phoneRepository) {
		return args -> {
			Person person = new Person();
			Phone phone1 = new Phone("123-456-7890");
			Phone phone2 = new Phone("321-654-0987");

			person.getPhones().add(phone1);
			person.getPhones().add(phone2);

			repository.save(person);
		};
	}
}
