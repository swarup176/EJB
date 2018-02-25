package com.cts.jpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "EMPLOYEE_TEST")
@NamedQuery(name = "getEmpDetails",query="SELECT OBJECT(Employee) from Employee employee")
@SequenceGenerator(name = "ProductSeq", sequenceName = "PERSON_SEQ")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8528618575572123135L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductSeq")
	@Column(name = "EMPID")
	private int EmpID;
	
	@Column(name = "EMPNAME")
	private String EmpName;

	@OneToOne(cascade = CascadeType.ALL, targetEntity=Passport.class)
	@JoinColumn(name = "EMPID", referencedColumnName="EMPID")
	private Passport passport;

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String EmpName) {
		this.EmpName = EmpName;
	}

	public void setEmpID(int empID) {
		EmpID = empID;
	}

	public int getEmpID() {
		return EmpID;
	} 


}
