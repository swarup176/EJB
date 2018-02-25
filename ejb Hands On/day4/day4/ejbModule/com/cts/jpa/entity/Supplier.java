package com.cts.jpa.entity;

import java.io.Serializable;
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
@Table(name = "supplier")
@SequenceGenerator(name = "AddressSeq", sequenceName = "ADDRESS_SEQ")
public class Supplier implements Serializable {

	/**
   * 
   */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AddressSeq")
	@Column(name = "sid")
	private int id;
	
	@Column(name = "sname", nullable = false, length = 250, insertable = true)
	private String sname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "supplierpart", joinColumns = { @JoinColumn(name = "sid", unique = true) }, inverseJoinColumns = { @JoinColumn   (name = "pid") })

	private Set<Part> part = new HashSet<Part>(0);

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param sname
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}

	/**
	 * @return
	 */
	public String getSname() {
		return sname;
	}

	/**
	 * @param part
	 */
	public void setProduct(Set<Part> part) {
		this.part = part;
	}

	/**
	 * @return
	 */
	public Set<Part> getProduct() {
		return part;
	}
}
