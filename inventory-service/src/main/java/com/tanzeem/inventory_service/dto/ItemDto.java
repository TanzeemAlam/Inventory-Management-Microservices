package com.tanzeem.inventory_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

	@NotNull(message = "Product reference cannot be null")
	private Long productId;
	
	@PositiveOrZero(message = "Available stock should be positive or zero")
	private Integer availableStock;
	
	@PositiveOrZero(message = "Reserved stock should be positive or zero")
	private Integer reservedStock;
	
	@PositiveOrZero(message = "OnOrder stock should be positive or zero")
	private Integer OnOrder;

	public Long getProductId() { return productId; }
	public void setProductId(Long productId) { this.productId = productId; }

	public Integer getAvailableStock() { return availableStock; }
	public void setAvailableStock(Integer availableStock) { this.availableStock = availableStock; }

	public Integer getReservedStock() { return reservedStock; }
	public void setReservedStock(Integer reservedStock) { this.reservedStock = reservedStock; }

	public Integer getOnOrder() { return OnOrder; }
	public void setOnOrder(Integer onOrder) { OnOrder = onOrder; }
}
