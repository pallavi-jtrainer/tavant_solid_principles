package com.tavant.SRP_Demo.entity;

import com.tavant.SRP_Demo.utils.CategoryType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private double price;
	private CategoryType category;
	private int quantity;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Product(String name, double price, CategoryType category, int quantity) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}
	
	
}
