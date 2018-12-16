package com.example.springdatajpasample.onetoone.uni;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NaturalId;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "PhoneOneToOneUni")
public class PhoneOneToOneUni {

	@Id
	@GeneratedValue
	private Long id;

	@NaturalId
	@Column(name = "number")
	private String number;

	@OneToOne
	@JoinColumn(name = "details_id")
	private PhoneDetailsOneToOneUni details;

	public PhoneOneToOneUni(String number) {
		this.number = number;
	}
	// Getters and setters are omitted for brevity

}