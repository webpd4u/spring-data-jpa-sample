package com.example.springdatajpasample.onetoone.bi.lazy;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity(name = "PhoneDetailsOneToOneBiLazy")
public class PhoneDetailsOneToOneBiLazy {

	@Id
	@GeneratedValue
	private Long id;

	private String provider;

	private String technology;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phone_id")
	private PhoneOneToOneBiLazy phone;

	// Getters and setters are omitted for brevity

}