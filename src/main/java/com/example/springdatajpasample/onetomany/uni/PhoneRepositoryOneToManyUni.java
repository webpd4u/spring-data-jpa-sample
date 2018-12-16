package com.example.springdatajpasample.onetomany.uni;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepositoryOneToManyUni extends JpaRepository<PhoneOneToManyUni, Long> {

	Optional<PhoneOneToManyUni> findByNumber(String number);
	

}
