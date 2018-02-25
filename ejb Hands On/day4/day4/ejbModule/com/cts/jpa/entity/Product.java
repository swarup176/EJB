package com.cts.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="PRODUCT")
@Entity
@DiscriminatorValue(value="PRODUCT")
public class Product extends AbstractProduct {

	@Column(name="PRICE")
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
