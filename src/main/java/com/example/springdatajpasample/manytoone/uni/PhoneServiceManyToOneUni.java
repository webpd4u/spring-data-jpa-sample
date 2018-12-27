package com.example.springdatajpasample.manytoone.uni;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
class PhoneServiceManyToOneUni {

	private final PhoneRepositoryManyToOneUniQuerydsl repository;

	PhoneServiceManyToOneUni(PhoneRepositoryManyToOneUniQuerydsl repository) {
		this.repository = repository;
	}

	public Optional<PhoneManyToOneUni> search(String number) {
		return repository.findOne(PhoneManyToOneUniPredicate.search(number));
	}
	
}
