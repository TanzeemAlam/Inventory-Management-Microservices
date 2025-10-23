package com.tanzeem.product_service.service;

import java.util.List;

import com.tanzeem.product_service.entity.Product;

public interface ProductService {
	
	public Product add(Product p);

	public List<Product> getAllProducts();

	public Product getProduct(Long id);
	
	public String updateProduct(Long id, Product updatedProduct);

	public String deleteProduct(Long id);	
}
