package com.example.springdatajpasample.manytoone.uni;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpasample.controller.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
class PhoneControllerManyToOneUni {

	private final PhoneRepositoryManyToOneUni repository;

	PhoneControllerManyToOneUni(PhoneRepositoryManyToOneUni repository) {
		this.repository = repository;
	}

	@GetMapping("/phones/{number}")
	PhoneManyToOneUni one(@PathVariable String number) {

		return repository.findByNumber(number).orElseThrow(() -> new DataNotFoundException(number));

	}
}
