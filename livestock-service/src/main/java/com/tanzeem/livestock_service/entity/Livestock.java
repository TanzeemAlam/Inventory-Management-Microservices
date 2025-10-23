package com.tanzeem.livestock_service.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Livestock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "Product reference cannot be null")
	private Long productId;
	
	@NotNull(message = "Warehouse id cannot be null")
	private Long wareshoueId;
	
	@NotNull(message = "Product reference cannot be null")
	private Integer physicalStock;
	
	private Date lastUpdated;

	public Long getId() {return id; }

	public Long getProductId() { return productId; }
	public void setProductId(Long productId) { this.productId = productId; }

	public Integer getPhysicalStock() { return physicalStock; }
	public void setPhysicalStock(Integer physicalStock) { this.physicalStock = physicalStock; }

	public Date getLastUpdated() { return lastUpdated; }
	public void setLastUpdated(Date lastUpdated) { this.lastUpdated = lastUpdated; }
}
