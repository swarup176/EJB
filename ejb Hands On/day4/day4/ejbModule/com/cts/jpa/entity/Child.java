package com.cts.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Administrator
 * 
 */
@Entity
@Table(name = "child")
@SequenceGenerator(name = "PersonSeq", sequenceName = "PERSON_SEQ")
public class Child {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PersonSeq")
	@Column(name = "id")
	private int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "cname", nullable = false, length = 50, insertable = true)
	private String cname;

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname
	 *            the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Parent.class)
	@JoinColumn(name = "PARENT_ID", referencedColumnName = "ID")
	private Parent parent;

	/**
	 * @return the parent
	 */
	public Parent getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Parent parent) {
		this.parent = parent;
	}

}