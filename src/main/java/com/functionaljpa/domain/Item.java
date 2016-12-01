package com.functionaljpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * Super class for warehouse items.
 * 
 * {@linkplain MappedSuperclass} is required by JPA. This allows
 * the child classes to use the id from the {@link Item} class. 
 */
@MappedSuperclass
public class Item {
	@Id
	@GeneratedValue
	private int itemId;	
	private String name;
	private String description;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Brand brand;
	
	public Item() {	}
	
	public Item(String name) {
		this(name, null, null);
	}
	
	public Item(String name, String description, Brand brand) {
		super();
		this.name = name;
		this.description = description;
		this.brand = brand;
	}
	
	public int getItemId() {
		return itemId;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Brand getBrand() {
		return this.brand;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ","
				+ " description=" + description + "brand=" + brand + "]";
	}	
}
