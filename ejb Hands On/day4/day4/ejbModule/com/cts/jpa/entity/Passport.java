package com.cts.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "passport_test")
@NamedQuery(name = "getPassPortDetails",query="SELECT OBJECT(Passport) from Passport")
public class Passport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 628834360504098775L;

	@Id
	@Column(name = "EMPID")
	private int empID;
	
	@Column(name = "COUNTRY")
	private String country;
		
	

		
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@OneToOne(mappedBy="passport", targetEntity=Employee.class, fetch=FetchType.EAGER)
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public int getEmpID() {
		return empID;
	}



}