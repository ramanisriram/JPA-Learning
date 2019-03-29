package com.vegetech.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name = "PET")
@Entity
public class Pet {
	@Id
	private BigDecimal id;
	private String name;
	private String dateOfBirth;
	private BigDecimal owner_id;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public BigDecimal getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(BigDecimal owner_id) {
		this.owner_id = owner_id;
	}

}