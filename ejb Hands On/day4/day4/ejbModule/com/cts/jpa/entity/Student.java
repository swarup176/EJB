package com.cts.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import com.cts.jpa.main.StudentListner;
@Entity
@EntityListeners(StudentListner.class)
public class Student {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6315638086090876061L;

	@Id
	@Column(name = "id")
	private String studentId;
	
	@Column(name = "name")
	private String stuName;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}


	

	
	
}
