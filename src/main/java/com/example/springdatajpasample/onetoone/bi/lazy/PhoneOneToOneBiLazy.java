package com.example.springdatajpasample.onetoone.bi.lazy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "PhoneOneToOneBiLazy")
public class PhoneOneToOneBiLazy {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "number")
	private String number;

	@OneToOne(
			mappedBy = "PhoneOneToOneBiLazy",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.LAZY
		)
	@LazyToOne( LazyToOneOption.NO_PROXY )
	private PhoneDetailsOneToOneBiLazy details;

	public PhoneOneToOneBiLazy(String number) {
		this.number = number;
	}
	// Getters and setters are omitted for brevity
	
	public void addDetails(PhoneDetailsOneToOneBiLazy details) {
		details.setPhone( this );
		this.details = details;
	}

	public void removeDetails() {
		if ( details != null ) {
			details.setPhone( null );
			this.details = null;
		}
	}

}