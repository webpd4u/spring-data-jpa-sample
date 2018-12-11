package com.example.springdatajpasample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.springdatajpasample.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	List<Customer> findByLastName(String lastName);
}
