package com.tanzeem.livestock_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Product reference cannot be null")
	private String name;
	
	@NotBlank(message = "Product reference cannot be null")
	private String location;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "livestock_id",nullable = false, foreignKey = @ForeignKey(name = "FK_PHYSICAL_LIVESTOCK_LOCATION"))
	private Livestock livestock;
	
}
