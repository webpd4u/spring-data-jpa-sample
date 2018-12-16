/*
 CREATE TABLE Person (
    id BIGINT NOT NULL ,
    PRIMARY KEY ( id )
)

CREATE TABLE Phone (
    id BIGINT NOT NULL ,
    number VARCHAR(255) ,
    person_id BIGINT ,
    PRIMARY KEY ( id )
 )

ALTER TABLE Phone
ADD CONSTRAINT PERSON_ID_FK
FOREIGN KEY (person_id) REFERENCES Person
 */
package com.example.springdatajpasample.onetomany.bi;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity(name = "PhoneOneToManyBi")
public class PhoneOneToManyBi {

	@Id
	@GeneratedValue
	private Long id;
	
	@NaturalId
	@Column(name = "number", unique = true)
	private String number;
	
	@ManyToOne
	private PersonOneToManyBi person;

	public PhoneOneToManyBi(String number) {
		this.number = number;
	}
	// Getters and setters are omitted for brevity
	
	@Override
	public boolean equals(Object o) {
		if ( this == o ) {
			return true;
		}
		if ( o == null || getClass() != o.getClass() ) {
			return false;
		}
		PhoneOneToManyBi phone = (PhoneOneToManyBi) o;
		return Objects.equals( number, phone.number );
	}

	@Override
	public int hashCode() {
		return Objects.hash( number );
	}

}