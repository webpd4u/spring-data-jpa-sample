package com.example.springdatajpasample.onetoone.uni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "PhoneDetailsOneToOneUni")
public class PhoneDetailsOneToOneUni {

	@Id
	@GeneratedValue
	private Long id;

	private String provider;

	private String technology;

	// Getters and setters are omitted for brevity

}