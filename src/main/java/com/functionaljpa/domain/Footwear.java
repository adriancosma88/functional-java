package com.functionaljpa.domain;

public class Footwear extends Item {
	private String color;
	private String material;
	private double size;
	
	public Footwear(String name) {
		super(name);
	}

	public Footwear(String name, String description, String color, String material, double size) {
		super(name, description);
		this.color = color;
		this.material = material;
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public String getMaterial() {
		return material;
	}

	public double getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "Footwear [ItemId=" + getItemId() + ", name=" + getName() + ", description="
				+ getDescription() + ", color=" + color + ", material=" + material + ", size=" + size + "]";
	}
	
	
}
