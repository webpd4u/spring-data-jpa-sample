package com.example.springdatajpasample.onetomany.uni;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpasample.controller.DataNotFoundException;
import com.example.springdatajpasample.onetomany.uni.Phone;
import com.example.springdatajpasample.onetomany.uni.PhoneRepository;

import lombok.extern.slf4j.Slf4j;

@Profile("OneToMany")
@Slf4j
@RestController
class PhoneController {

	private final PhoneRepository repository;

	PhoneController(PhoneRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/phones/oto/{number}")
	Phone one(@PathVariable String number) {

		return repository.findByNumber(number).orElseThrow(() -> new DataNotFoundException(number));

	}
}
