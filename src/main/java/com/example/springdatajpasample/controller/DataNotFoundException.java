package com.example.springdatajpasample.controller;

class DataNotFoundException extends RuntimeException {

	DataNotFoundException(Long id) {
		super("Could not find data " + id);
	}

	DataNotFoundException(Integer id) {
		super("Could not find data " + id);
	}
}
