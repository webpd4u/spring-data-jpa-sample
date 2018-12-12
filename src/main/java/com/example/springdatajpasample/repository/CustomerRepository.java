package com.example.springdatajpasample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdatajpasample.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByLastName(String lastName);
}
