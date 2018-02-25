package com.cts.jpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="TRAVEL_GUIDE")
@DiscriminatorValue(value="TRAVEL GUIDE")
@Entity
public class TravelGuide extends Book {

	private String country;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
