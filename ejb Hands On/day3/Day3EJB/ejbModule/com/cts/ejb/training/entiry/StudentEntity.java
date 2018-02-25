package com.cts.ejb.training.entiry;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name = "student")
@SequenceGenerator(name = "RupSeq", sequenceName = "RUP_SEQ")

public class StudentEntity {
	 /**
	   * 
	   */
	  private static final long serialVersionUID = 1L;

	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RupSeq")
	  @Column(name = "id")
	  private int id;
	  
	  @Column(name = "name")
	  private String name;

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
