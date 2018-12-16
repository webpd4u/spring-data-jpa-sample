package com.example.springdatajpasample.manytomany.bi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.NaturalId;

@Entity(name = "PersonManyToManyBi")
public class PersonManyToManyBi {

	@Id
	@GeneratedValue
	private Long id;

	@NaturalId
	private String registrationNumber;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<AddressManyToManyBi> addresses = new ArrayList<>();

	//Getters and setters are omitted for brevity

	public void addAddress(AddressManyToManyBi address) {
		addresses.add( address );
		address.getOwners().add( this );
	}

	public void removeAddress(AddressManyToManyBi address) {
		addresses.remove( address );
		address.getOwners().remove( this );
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		PersonManyToManyBi person = (PersonManyToManyBi) o;
		return Objects.equals( registrationNumber, person.registrationNumber );
	}

	@Override
	public int hashCode() {
		return Objects.hash( registrationNumber );
	}

}