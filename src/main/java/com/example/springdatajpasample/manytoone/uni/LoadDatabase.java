package com.example.springdatajpasample.manytoone.uni;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;

@Profile("ManyToOne")
@Configuration
@Slf4j
class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(PersonRepository repository, PhoneRepository phoneRepository) {
		return args -> {
			Person person = new Person();
			repository.save( person );

			Phone phone = new Phone( "123-456-7890" );
			phone.setPerson( person );
			phoneRepository.save( phone );
		};
	}
}
