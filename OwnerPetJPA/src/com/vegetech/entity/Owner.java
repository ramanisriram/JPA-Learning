package com.vegetech.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "OWNER")
@Entity
public class Owner {
	@Id
	private BigDecimal id;
	private String first_name;
	private String last_name;
	private String city;
	private BigDecimal pet_id;
	
	@JoinColumns({
		@JoinColumn(name="pet_id", referencedColumnName="ID")
	})	
	@OneToMany
	private List<Pet> pet;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public BigDecimal getPet_id() {
		return pet_id;
	}

	public void setPet_id(BigDecimal pet_id) {
		this.pet_id = pet_id;
	}

	public List<Pet> getPet() {
		return pet;
	}

	public void setPet(List<Pet> pet) {
		this.pet = pet;
	}
}