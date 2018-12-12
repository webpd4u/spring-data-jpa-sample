package com.example.springdatajpasample.manytoone.uni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.context.annotation.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Profile("ManyToOne")
@Data
@NoArgsConstructor
@Entity(name = "Person")
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	public Person(Long id) {
		this.id = id;
	}

	// Getters and setters are omitted for brevity

}