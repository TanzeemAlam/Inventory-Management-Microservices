package com.tanzeem.livestock_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class LivestockDto {
	
	@NotNull(message = "Product reference cannot be null")
	private Long productId;
	
	@NotNull(message = "Warehouse id cannot be null")
	private Long wareshoueId;
	
	@NotNull(message = "Product reference cannot be null")
	private Integer physicalStock;

	public Long getProductId() { return productId; }
	public void setProductId(Long productId) { this.productId = productId; }
	
	public Long getWareshoueId() { return wareshoueId; }
	public void setWareshoueId(Long wareshoueId) { this.wareshoueId = wareshoueId; }
	
	public Integer getPhysicalStock() { return physicalStock; }
	public void setPhysicalStock(Integer physicalStock) { this.physicalStock = physicalStock;}
}
