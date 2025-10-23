package com.tanzeem.inventory_service.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//Act as indirect foreign key for product in product-service
	@NotNull(message = "Product reference cannot be null")
	private Long productId;
	
	@PositiveOrZero(message = "Available stock should be positive or zero")
	private Integer availableStock;
	
	@PositiveOrZero(message = "Reserved stock should be positive or zero")
	private Integer reservedStock;
	
	@PositiveOrZero(message = "OnOrder stock should be positive or zero")
	private Integer OnOrder;
	
	private Date lastSynced;

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Long getProductId() { return productId; }
	public void setProductId(Long productId) { this.productId = productId; }

	public Integer getAvailableStock() { return availableStock; }
	public void setAvailableStock(Integer availableStock) { this.availableStock = availableStock; }

	public Integer getReservedStock() { return reservedStock; }
	public void setReservedStock(Integer reservedStock) { this.reservedStock = reservedStock; }

	public Integer getOnOrder() { return OnOrder; }
	public void setOnOrder(Integer onOrder) { OnOrder = onOrder; }

	public Date getLastSynced() { return lastSynced; }
	public void setLastSynced(Date lastSynced) { this.lastSynced = lastSynced; }
}
