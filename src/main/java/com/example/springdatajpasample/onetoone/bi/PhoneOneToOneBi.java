package com.example.springdatajpasample.onetoone.bi;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "PhoneOneToOneBi")
public class PhoneOneToOneBi {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "number")
	private String number;

	@OneToOne(
			mappedBy = "phoneOneToOneBi",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.LAZY
		)
	private PhoneDetailsOneToOneBi details;

	public PhoneOneToOneBi(String number) {
		this.number = number;
	}
	// Getters and setters are omitted for brevity
	
	public void addDetails(PhoneDetailsOneToOneBi details) {
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