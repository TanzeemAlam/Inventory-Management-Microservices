package com.tanzeem.product_service.util;

import java.time.LocalDateTime;

public class ApiResponse {
	
	private String message;
	private LocalDateTime timestamp;
	
	public ApiResponse(String message) {		
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
}
