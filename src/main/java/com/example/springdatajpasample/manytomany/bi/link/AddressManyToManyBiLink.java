package com.example.springdatajpasample.manytomany.bi.link;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.tomcat.jni.Address;

import lombok.Data;

@Data
@Entity(name = "AddressManyToManyBiLink")
public class AddressManyToManyBiLink implements Serializable{

	@Id
	@GeneratedValue
	private Long id;

	private String street;

	@Column(name = "`number`")
	private String number;

	private String postalCode;

	@OneToMany(
		mappedBy = "address",
		cascade = CascadeType.ALL,
		orphanRemoval = true
	)
	private List<PersonAddress> owners = new ArrayList<>();

	//Getters and setters are omitted for brevity

	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		AddressManyToManyBiLink address = (AddressManyToManyBiLink) o;
		return Objects.equals( street, address.street ) &&
				Objects.equals( number, address.number ) &&
				Objects.equals( postalCode, address.postalCode );
	}

	@Override
	public int hashCode() {
		return Objects.hash( street, number, postalCode );
	}

}