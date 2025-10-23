package com.tanzeem.product_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductDto {
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	private String description;
	
	@Positive(message = "Price should be positive")
	private Double price;
	
	@NotBlank(message = "Product sku is mandatory")
	private String sku;
	
	@NotBlank(message = "Product category is mandatory")
	private String category;
	
	public ProductDto() {}
	
	public ProductDto(Long id, String name, String description, double price, String sku, String category) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.sku = sku;
		this.category = category;
	}

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
}
