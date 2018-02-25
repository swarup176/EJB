package com.cts.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Administrator
 * 
 */
@Entity
@Table(name = "parent")
@SequenceGenerator(name = "ParentSeq", sequenceName = "ADDRESS_SEQ")
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ParentSeq")
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

	@Column(name = "pname", nullable = false, length = 50, insertable = true)
	private String pname;

	/**
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * @param pname
	 *            the pname to set
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", targetEntity = Child.class)
	private List<Child> children = new ArrayList<Child>(0);

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(List<Child> children) {
		this.children = children;
	}

}
