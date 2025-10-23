package com.tanzeem.user_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AuthRequestDto {

	@NotNull(message = "Field cannot be null")
	private String username;
	
	@NotNull(message = "Field cannot be null")
	private String password;
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
