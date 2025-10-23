package com.tanzeem.livestock_service.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanzeem.livestock_service.dto.LivestockDto;
import com.tanzeem.livestock_service.entity.Livestock;
import com.tanzeem.livestock_service.service.LivestockService;
import com.tanzeem.livestock_service.util.ApiResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("livestock")
public class LivestockController {

	@Autowired
	LivestockService livestockService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/status")
	public String status() {
		return "Livestock service is UP and running";
	}
	
	@PostMapping()
	public ResponseEntity<ApiResponse> addStock(@Valid @RequestBody LivestockDto dto) {
		livestockService.addStock(dto);
		
		return ResponseEntity.status(null).body(new ApiResponse(null));
	}
	
	@PutMapping()
	public void updateStock(@Valid @RequestBody LivestockDto dto) {
	}
	
	@GetMapping("/{productId}")
	public void getProductAcrossWarehouses() {}
	
	@GetMapping("/warehouse/{warehouseId}")
	public void getAllProductsInWarehouse() {}
	
	@GetMapping("/warehouse/{warehouseId}/{productId}")
	public void getProductInWarehouse() {}
	
	@PostMapping("sync")
	public void sync() {}
	
	/***
	 * All DTO to Entity and vice versa operations
	 
	private Livestock convertToEntity(@Valid ProductDto dto) {
		return modelMapper.map(dto, Product.class);
	}

	private ProductDto convertToDto(Product product) {
		return modelMapper.map(product, ProductDto.class);
	}

	private List<ProductDto> convertToDtoList(List<Product> products) {
		return products.stream()
				.map(product -> modelMapper.map(product, ProductDto.class))
				.collect(Collectors.toList());
	}*/
}
