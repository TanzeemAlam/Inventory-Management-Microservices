package com.tanzeem.user_service.service;

import org.springframework.stereotype.Service;

import com.tanzeem.user_service.entity.User;

import jakarta.validation.Valid;

public interface UserService {

	User register(@Valid User dto);

	void saveVerificationTokenForUser(String token, User user);

	String validateVerificationToken(String token);

}
