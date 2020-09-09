package com.food;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Food {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int sno;
	private String fooditems;
	private int price;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getFooditems() {
		return fooditems;
	}
	public void setFooditems(String fooditems) {
		this.fooditems = fooditems;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Food(String fooditems, int price) {
		super();
		this.fooditems = fooditems;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Food [sno=" + sno + ", fooditems=" + fooditems + ", price=" + price + "]";
	}
	
}
