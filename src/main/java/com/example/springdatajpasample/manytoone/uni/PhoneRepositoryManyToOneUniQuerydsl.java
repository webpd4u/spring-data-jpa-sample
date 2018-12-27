package com.example.springdatajpasample.manytoone.uni;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PhoneRepositoryManyToOneUniQuerydsl 
	extends JpaRepository<PhoneManyToOneUni, Long>, QuerydslPredicateExecutor<PhoneManyToOneUni> {

	Optional<PhoneManyToOneUni> findByNumber(String number);
	

}
