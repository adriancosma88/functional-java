package com.functionaljpa.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	public Item() {	}
	
	public Item(String name) {
		this(name, null);
	}
	
	public Item(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", description=" + description + "]";
	}	
}
