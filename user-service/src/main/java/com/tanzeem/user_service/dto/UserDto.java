package com.tanzeem.user_service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;

public class UserDto {
	
	@NotNull(message = "Field cannot be null")
	private String username;
	
	@Column(length = 60)
	private String password;
	
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
