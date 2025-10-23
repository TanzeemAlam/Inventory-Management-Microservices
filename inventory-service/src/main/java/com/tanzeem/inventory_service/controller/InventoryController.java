package com.tanzeem.inventory_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tanzeem.inventory_service.dto.ItemDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("inventory")
public class InventoryController {

	
	@GetMapping("/status")
	public String healthCheck() {
		return "Inventory is UP and running";
	}
	
	@GetMapping
	public void getAllStock() {
		
	}
	
	@GetMapping("{productId}")
	public void getStock() {
		
	}
	
	@PutMapping("{productId}")
	public void updateStock() {										//Called by LiveStock Service
		
	}
	
	@PostMapping("/reserve")										//Called by Order Service
	public void reserveStock() {
		
	}
	
	@PostMapping("/release")										//Called by Order Service
	public void releaseStock() {
		
	}
		
	@PostMapping("/commit")											//Called by Order Service
	public void commitReservedStock() {
		
	}
	
	@GetMapping("/available/{productId}")							//Called by Order Service
	public void getAvailableStock() {}
	
	@GetMapping("/reserved/{productId}")							//Called by Order Service
	public void getReservedStock() {}
	
	@PostMapping("/sync")											//Called by LiveStock Service
	public void syncFromLivestock() {}
}
