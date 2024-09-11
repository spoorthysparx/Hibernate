package com.hexa.hibernation.com.hexaware.hibernation1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITBook")
public class Book {
	@Id
	int bno;
	
	@Column(name="bkName")
	String name;
	
	@Column
	double price;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bno=" + bno + ", name=" + name + ", price=" + price + "]";
	}
	
}
