package com.example.springdatajpasample.manytomany.uni;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Address")
public class AddressManyToManyUni {

	@Id
	@GeneratedValue
	private Long id;

	private String street;

	@Column(name = "`number`")
	private String number;

	//Getters and setters are omitted for brevity

}