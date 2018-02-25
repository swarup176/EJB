package com.cts.jpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Table(name="ABSTRACT_PRODUCT")
@Inheritance(strategy=InheritanceType.JOINED)
//@SequenceGenerator(name="productSeq",sequenceName="PRODUCT_SEQ")
@DiscriminatorColumn(name="TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value="abs product")
@Entity
public abstract class AbstractProduct {
	
	 @Id
	    @TableGenerator(name="TABLE_GEN", table="SEQUENCE_TABLE", pkColumnName="SEQ_NAME",
	        valueColumnName="SEQ_COUNT", pkColumnValue="EMP_SEQ")
	    @GeneratedValue(strategy=GenerationType.TABLE, generator="TABLE_GEN")
	@Column(name="PRODUCT_ID")
	private Integer productId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getProductId() {
		return productId;
	}
	
	
}
