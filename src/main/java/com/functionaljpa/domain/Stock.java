package com.functionaljpa.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Stock {
	@Id
	@GeneratedValue
	private int stockId;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Footwear footwear;
	
	@Enumerated
	private Color color;
	
	private double size;
	
	private int quantity;
	
	public Stock() { }

	public Stock(Footwear footwear, Color color, double size, int quantity) {
		super();
		this.footwear = footwear;
		this.color = color;
		this.size = size;
		this.quantity = quantity;
	}

	public int getStockId() {
		return stockId;
	}

	public Item getItem() {
		return footwear;
	}

	public Color getColor() {
		return color;
	}

	public double getSize() {
		return size;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void modifyQuantity(int value) {
		this.quantity = this.quantity + value;
	}

	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", item=" + footwear + ", color=" + color + ", size=" + size + "]";
	}
}
