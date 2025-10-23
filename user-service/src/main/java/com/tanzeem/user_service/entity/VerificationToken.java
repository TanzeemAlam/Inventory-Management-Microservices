package com.tanzeem.user_service.entity;

import jakarta.persistence.*;

@Entity
public class VerificationToken {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String token;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id",nullable = false, foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN"))
	private User user;
	
	
	public VerificationToken() {}
	
	public VerificationToken(String token, User user) {
		super();
		this.token = token;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
