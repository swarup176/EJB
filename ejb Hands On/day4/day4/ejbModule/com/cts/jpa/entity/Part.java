package com.cts.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Part")
@SequenceGenerator(name = "ProductSeq", sequenceName = "PERSON_SEQ")
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductSeq")
	@Column(name = "pid")
	private int id;

	@Column(name = "pname", nullable = false, length = 50, insertable = true)
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "supplierpart", joinColumns = { @JoinColumn(name = "pid", unique = true) }, inverseJoinColumns = { @JoinColumn   (name = "sid") })

	private Set<Supplier> supplier = new HashSet<Supplier>(0);

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param supplier
	 */
	public void setSupplier(Set<Supplier> supplier) {
		this.supplier = supplier;
	}

	/**
	 * @return
	 */
	public Set<Supplier> getSupplier() {
		return supplier;
	}
}
