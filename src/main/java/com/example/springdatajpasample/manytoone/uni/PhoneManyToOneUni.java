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
package com.example.springdatajpasample.manytoone.uni;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Profile;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity(name = "PhoneManyToOneUni")
public class PhoneManyToOneUni {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "number")
	private String number;

	@ManyToOne
	@JoinColumn(name = "person_id", foreignKey = @ForeignKey(name = "PERSON_ID_FK"))
	private PersonManyToOneUni person;

	public PhoneManyToOneUni(String number) {
		this.number = number;
	}
	// Getters and setters are omitted for brevity

}