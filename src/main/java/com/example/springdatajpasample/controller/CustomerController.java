package com.example.springdatajpasample.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdatajpasample.entity.Address;
import com.example.springdatajpasample.entity.City;
import com.example.springdatajpasample.entity.Country;
import com.example.springdatajpasample.entity.Customer;
import com.example.springdatajpasample.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
class CustomerController {

	private final CustomerRepository repository;

	CustomerController(CustomerRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/customers/{id}")
	Customer one(@PathVariable Integer id) {

//		return repository.findById(id).orElseThrow(() -> new DataNotFoundException(id));
		Optional<Customer> optional = repository.findById(id);
		Customer customer = null;
		
		if(optional.isPresent()) {
			customer = optional.get();
			
			Address address = customer.getAddress();
			
			
			City city = address.getCity();
			
			Country country = city.getCountry();
			
			log.debug("Customer id {} LastName {} FirstName {}. "
					+ "Address id {} Address {}."
					+ "City id {} city {}."
					+ "Country id {} country {}.", 
					customer.getCustomerId(), customer.getLastName(), customer.getFirstName(),
					address.getAddressId(), address.getAddress(),
					city.getCityId(), city.getCity(),
					country.getCountryId(), country.getCountry());
			
		} else {
			throw new DataNotFoundException(id);
		}
		
		return customer;
	}
}
