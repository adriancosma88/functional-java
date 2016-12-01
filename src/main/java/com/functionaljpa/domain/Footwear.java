package com.functionaljpa.domain;

import javax.persistence.Entity;

@Entity
public class Footwear extends Item {
	private Material material;
	
	public Footwear() {	}
	
	public Footwear(String name) {
		super(name);
	}

	public Footwear(String name, String description, Brand brand,
			Material material) {
		super(name, description, brand);
		this.material = material;
	}

	public Material getMaterial() {
		return material;
	}

	@Override
	public String toString() {
		return "Footwear [ItemId=" + getItemId() 
				+ ", name=" + getName()	+ ", description=" + getDescription() 
				+ ", brand=" + getBrand();
	}
}
