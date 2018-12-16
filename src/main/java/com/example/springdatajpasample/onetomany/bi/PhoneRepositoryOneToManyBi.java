package com.example.springdatajpasample.onetomany.bi;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepositoryOneToManyBi extends JpaRepository<PhoneOneToManyBi, Long> {

	Optional<PhoneOneToManyBi> findByNumber(String number);
	

}
