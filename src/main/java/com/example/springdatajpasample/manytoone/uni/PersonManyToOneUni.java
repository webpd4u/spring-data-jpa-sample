package com.example.springdatajpasample.manytoone.uni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.context.annotation.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity(name = "PersonManyToOneUni")
public class PersonManyToOneUni {

	@Id
	@GeneratedValue
	private Long id;
	
	private String lastName;

	public PersonManyToOneUni(Long id) {
		this.id = id;
	}

	// Getters and setters are omitted for brevity

}