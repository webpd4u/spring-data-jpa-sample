package com.example.springdatajpasample.manytomany.bi.link;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity(name = "PersonAddress")
public class PersonAddress implements Serializable {

	@Id
	@ManyToOne
	private PersonManyToManyBiLink person;

	@Id
	@ManyToOne
	private AddressManyToManyBiLink address;

	public PersonAddress(PersonManyToManyBiLink person, AddressManyToManyBiLink address) {
		this.person = person;
		this.address = address;
	}
	//Getters and setters are omitted for brevity

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		PersonAddress that = (PersonAddress) o;
		return Objects.equals( person, that.person ) &&
				Objects.equals( address, that.address );
	}

	@Override
	public int hashCode() {
		return Objects.hash( person, address );
	}


}