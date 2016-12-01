package com.functionaljpa.domain;

import javax.persistence.Entity;

@Entity
public class Footwear extends Item {
	private Color color;
	private Material material;
	private double size;
	
	public Footwear() {	}
	
	public Footwear(String name) {
		super(name);
	}

	public Footwear(String name, String description, Brand brand,
			Color color, Material material, double size) {
		super(name, description, brand);
		this.color = color;
		this.material = material;
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public Material getMaterial() {
		return material;
	}

	public double getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "Footwear [ItemId=" + getItemId() 
				+ ", name=" + getName()	+ ", description=" + getDescription() 
				+ ", brand=" + getBrand()
				+ ", color=" + color + ", material=" + material 
				+ ", size=" + size + "]";
	}
	
	
}
