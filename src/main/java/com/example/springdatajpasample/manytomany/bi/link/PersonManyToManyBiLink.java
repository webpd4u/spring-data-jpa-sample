package com.example.springdatajpasample.manytomany.bi.link;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.tomcat.jni.Address;
import org.hibernate.annotations.NaturalId;

@Entity(name = "PersonManyToManyBiLink")
public class PersonManyToManyBiLink implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@NaturalId
	private String registrationNumber;

	@OneToMany(
		mappedBy = "person",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	private List<PersonAddress> addresses = new ArrayList<>();

	//Getters and setters are omitted for brevity

	public void addAddress(AddressManyToManyBiLink address) {
		PersonAddress personAddress = new PersonAddress( this, address );
		addresses.add( personAddress );
		address.getOwners().add( personAddress );
	}

	public void removeAddress(AddressManyToManyBiLink address) {
		PersonAddress personAddress = new PersonAddress( this, address );
		address.getOwners().remove( personAddress );
		addresses.remove( personAddress );
		personAddress.setPerson( null );
		personAddress.setAddress( null );
	}

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		PersonManyToManyBiLink person = (PersonManyToManyBiLink) o;
		return Objects.equals( registrationNumber, person.registrationNumber );
	}

	@Override
	public int hashCode() {
		return Objects.hash( registrationNumber );
	}

}