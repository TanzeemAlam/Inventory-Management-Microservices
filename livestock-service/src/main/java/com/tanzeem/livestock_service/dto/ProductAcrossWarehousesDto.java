package com.tanzeem.livestock_service.dto;

import java.util.List;

import com.tanzeem.livestock_service.entity.Warehouse;

import jakarta.validation.constraints.NotNull;

public class ProductAcrossWarehousesDto {
	
	private Long productId;
	private List<Warehouse> warehouses;
	private Integer physicalStock;
}
