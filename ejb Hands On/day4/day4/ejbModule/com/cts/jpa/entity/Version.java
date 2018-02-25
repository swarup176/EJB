package com.cts.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="TEST_VERSION")
@Entity
public class Version {

	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
    @Column
    private String phone;

    public void setId(Integer id) {
		this.id = id;
	}


	@javax.persistence.Version
    private int version;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
}
