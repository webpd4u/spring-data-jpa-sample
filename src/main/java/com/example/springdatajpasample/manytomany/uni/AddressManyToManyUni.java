package com.example.springdatajpasample.manytomany.uni;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "AddressManyToManyUni")
public class AddressManyToManyUni {
	@Id
	@GeneratedValue
	private Long id;

	private String street;

	@Column(name = "number")
	private String number;
	
	public AddressManyToManyUni(String street, String number) {
		this.street = street;
		this.number = number;
	}

	//Getters and setters are omitted for brevity

}