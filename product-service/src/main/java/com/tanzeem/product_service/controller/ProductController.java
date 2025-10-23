package com.tanzeem.product_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.tanzeem.product_service.dto.ProductDto;
import com.tanzeem.product_service.entity.Product;
import com.tanzeem.product_service.service.impl.ProductServiceImpl;
import com.tanzeem.product_service.util.ApiResponse;
import com.tanzeem.product_service.util.AppConstants;

@RestController()
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/status")
	public ResponseEntity<ApiResponse> getAuthorizationStatus() {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(AppConstants.PRODUCT_SERVICE_STATUS));
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse> addProduct(@Valid @RequestBody ProductDto dto) {
		productService.add(convertToEntity(dto));
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(AppConstants.PRODUCT_CREATED));
	}
	
	@GetMapping
	public List<ProductDto> getAllProduct() {
		return convertToDtoList(productService.getAllProducts());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduct(@PathVariable Long id) {
		Product product = productService.getProduct(id);
		
		if (product != null) 
			return ResponseEntity.status(HttpStatus.OK).body(convertToDto(product));
		else 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(AppConstants.NOT_FOUND));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable Long id, @RequestBody Product p) {
		String response = productService.updateProduct(id, p);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(response));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long id) {
		String response = productService.deleteProduct(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(response));
	}
	
	/**
	 * All DTO to Entity and vice versa operations
	 */
	private Product convertToEntity(@Valid ProductDto dto) {
		return modelMapper.map(dto, Product.class);
	}
	
	private ProductDto convertToDto(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}
	
	private List<ProductDto> convertToDtoList(List<Product> products) {
		return products.stream()
				.map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}

}
