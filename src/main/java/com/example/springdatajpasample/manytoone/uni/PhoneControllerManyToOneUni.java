package com.example.springdatajpasample.manytoone.uni;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpasample.controller.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
class PhoneControllerManyToOneUni {

	private final PhoneServiceManyToOneUni service;

	PhoneControllerManyToOneUni(PhoneServiceManyToOneUni service) {
		this.service = service;
	}

	@GetMapping("/phones/{number}")
	PhoneManyToOneUni one(@PathVariable String number) {

//		return repository.findByNumber(number).orElseThrow(() -> new DataNotFoundException(number));
		Optional<PhoneManyToOneUni> optional = service.search(number);
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new DataNotFoundException(number);
		}
		
	}
}
