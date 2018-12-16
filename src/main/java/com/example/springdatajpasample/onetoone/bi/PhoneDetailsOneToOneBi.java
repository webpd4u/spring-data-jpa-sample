package com.example.springdatajpasample.onetoone.bi;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity(name = "PhoneDetailsOneToOneBi")
public class PhoneDetailsOneToOneBi {

	@Id
	@GeneratedValue
	private Long id;

	private String provider;

	private String technology;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phone_id")
	private PhoneOneToOneBi phone;

	// Getters and setters are omitted for brevity

}