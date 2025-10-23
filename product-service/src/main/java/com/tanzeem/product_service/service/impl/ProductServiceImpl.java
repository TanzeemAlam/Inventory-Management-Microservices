package com.tanzeem.product_service.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanzeem.product_service.entity.Product;
import com.tanzeem.product_service.repository.ProductRepository;
import com.tanzeem.product_service.service.ProductService;
import com.tanzeem.product_service.util.AppConstants;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository repository;
	
	@Override
	public Product add(Product p) { 
		p.setCreatedAt(new Date());														//Product creation date
		
		return repository.save(p);
	}

	@Override
	public List<Product> getAllProducts() { return repository.findAll(); }

	@Override
	public Product getProduct(Long id) { return repository.findById(id).orElse(null); }

	@Override
	public String updateProduct(Long id, Product updatedProduct) {
		Product p = repository.findById(id).orElse(null);
		
		if (p != null) { 
			p.setName(updatedProduct.getName());
			p.setDescription(updatedProduct.getDescription());
			p.setPrice(updatedProduct.getPrice());
			p.setUpdatedAt(new Date());													//Product Updated date
			
			
			repository.save(p);
			
			return AppConstants.PRODUCT_UPDATED;
		}
		
		return AppConstants.NOT_FOUND;
	}

	@Override
	public String deleteProduct(Long id) {
		Product p = repository.findById(id).orElse(null);
		
		if (p != null) {
			repository.delete(p);
			
			return AppConstants.PRODUCT_DELETED;
		}
		
		return AppConstants.NOT_FOUND;		
	}

}
