package com.example.springdatajpasample.controller;

public class DataNotFoundException extends RuntimeException {

	public DataNotFoundException(Long id) {
		super("Could not find data " + id);
	}

	public DataNotFoundException(Integer id) {
		super("Could not find data " + id);
	}

	public DataNotFoundException(String number) {
		super("Could not find data " + number);
	}
}
