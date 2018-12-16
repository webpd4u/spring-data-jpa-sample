package com.example.springdatajpasample.manytomany.uni;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.tomcat.jni.Address;

@Entity(name = "PersonManyToManyUni")
public class PersonManyToManyUni {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Address> addresses = new ArrayList<>();

	//Getters and setters are omitted for brevity

}