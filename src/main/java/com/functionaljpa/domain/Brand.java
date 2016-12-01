package com.functionaljpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Brand {
	@Id
	@GeneratedValue
	private int brandId;
	private String name;
	
	public Brand() { }	
	
	public Brand(String name) {
		super();
		this.name = name;
	}

	public int getBrandId() {
		return brandId;
	}
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", name=" + name + "]";
	}	
}
