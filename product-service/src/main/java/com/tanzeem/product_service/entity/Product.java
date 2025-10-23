package com.tanzeem.product_service.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	private String description;
	
	@Positive(message = "Price should be positive")
	private Double price;
	
	@NotBlank(message = "Product sku is mandatory")
	private String sku;
	
	@NotBlank(message = "Product category is mandatory")
	private String category;
	
	private Date createdAt;
	private Date updatedAt;
	
	public Product() {}
	
	public Product(Long id, String name, String description, double price, String sku, String category, Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.sku = sku;
		this.category = category;
		this.createdAt = createdAt;
	}
	
	public Long getId() { return id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }

	public Double getPrice() { return price; }
	public void setPrice(Double price) { this.price = price; }

	public String getSku() { return sku; }
	public void setSku(String sku) { this.sku = sku; }

	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }

	public Date getCreatedAt() { return createdAt; }
	public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
	
	public Date getUpdatedAt() { return updatedAt; }
	public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
}

