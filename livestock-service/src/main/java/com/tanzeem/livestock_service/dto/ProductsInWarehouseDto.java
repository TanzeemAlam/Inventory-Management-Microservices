package com.tanzeem.livestock_service.dto;

import java.util.List;

import com.tanzeem.livestock_service.entity.Warehouse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ProductsInWarehouseDto {
	private List<ProductDto> products;
	private List<Warehouse> warehouses;
	private Integer physicalStock;
	
	public List<ProductDto> getProducts() { return products; }
	public void setProducts(List<ProductDto> products) { this.products = products; }
	
	public List<Warehouse> getWarehouses() { return warehouses; }
	public void setWarehouses(List<Warehouse> warehouses) { this.warehouses = warehouses; }
	
	public Integer getPhysicalStock() { return physicalStock; }
	public void setPhysicalStock(Integer physicalStock) { this.physicalStock = physicalStock; }
}
