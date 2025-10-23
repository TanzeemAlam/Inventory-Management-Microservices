package com.tanzeem.livestock_service.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	private String name;
	private String description;
	private Double price;
	private String sku;
	private String category;

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

