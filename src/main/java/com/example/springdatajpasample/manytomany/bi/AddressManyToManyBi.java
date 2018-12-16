package com.example.springdatajpasample.manytomany.bi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity(name = "Address")
public class AddressManyToManyBi {

	@Id
	@GeneratedValue
	private Long id;

	private String street;

	@Column(name = "`number`")
	private String number;

	private String postalCode;

	@ManyToMany(mappedBy = "addresses")
	private List<PersonManyToManyBi> owners = new ArrayList<>();

	//Getters and setters are omitted for brevity

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		AddressManyToManyBi address = (AddressManyToManyBi) o;
		return Objects.equals( street, address.street ) &&
				Objects.equals( number, address.number ) &&
				Objects.equals( postalCode, address.postalCode );
	}

	@Override
	public int hashCode() {
		return Objects.hash( street, number, postalCode );
	}

}