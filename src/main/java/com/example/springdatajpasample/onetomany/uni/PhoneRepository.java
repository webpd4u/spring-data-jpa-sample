package com.example.springdatajpasample.onetomany.uni;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
@Profile("OneToMany")
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	Optional<Phone> findByNumber(String number);
	

}
