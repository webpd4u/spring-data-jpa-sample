package com.example.springdatajpasample.onetomany.uni;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpasample.controller.DataNotFoundException;
import com.example.springdatajpasample.onetomany.uni.PhoneOneToManyUni;
import com.example.springdatajpasample.onetomany.uni.PhoneRepositoryOneToManyUni;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
class PhoneControllerOneToManyUni {

	private final PhoneRepositoryOneToManyUni repository;

	PhoneControllerOneToManyUni(PhoneRepositoryOneToManyUni repository) {
		this.repository = repository;
	}

	@GetMapping("/phones/oto/{number}")
	PhoneOneToManyUni one(@PathVariable String number) {

		return repository.findByNumber(number).orElseThrow(() -> new DataNotFoundException(number));

	}
}
