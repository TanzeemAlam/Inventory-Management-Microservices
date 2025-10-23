package com.tanzeem.user_service.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.tanzeem.user_service.dto.AuthRequestDto;
import com.tanzeem.user_service.dto.UserDto;
import com.tanzeem.user_service.entity.User;
import com.tanzeem.user_service.event.RegistrationEvent;
import com.tanzeem.user_service.service.UserService;
import com.tanzeem.user_service.service.impl.CustomUserDetailService;
import com.tanzeem.user_service.util.JwtUtil;
import com.tanzeem.user_service.util.ApiResponse;
import com.tanzeem.user_service.util.AppConstants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("user")
public class UserServiceController {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceController.class);
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@GetMapping("/status")
	public ResponseEntity<ApiResponse> status() {
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(AppConstants.USER_SERVICE_STATUS));
	}
	
	@GetMapping("/token")
	public ResponseEntity<ApiResponse> login(@RequestBody AuthRequestDto dto) {
		String jwtToken = null;
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
			
			UserDetails userDetails = customUserDetailService.loadUserByUsername(dto.getUsername());
			
			jwtToken = jwtUtil.generateToken(userDetails.getUsername());
			
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(AppConstants.JWT_TOKEN + jwtToken));
		} catch (Exception e) {
			logger.error("Exception occurred while creation", e.getMessage());
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(AppConstants.USER_NOT_FOUND));
		}
	}
	
	@GetMapping("/validateToken")
	public ResponseEntity<ApiResponse> validate(@RequestParam String token) {
		
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse(AppConstants.VALID_TOKEN));
	}
	
	@PostMapping("/register")
	public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody UserDto dto, HttpServletRequest request) {
		User user = userService.register(convertToEntity(dto));
		
		publisher.publishEvent(new RegistrationEvent(user, applicationURL(request)));
		
		logger.info("User register event published");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(AppConstants.USER_REGISTRATION_SUCCESS));
	}
	
	@GetMapping("/verifyRegistration")
	public ResponseEntity<ApiResponse> verifyRegistration(@RequestParam String token) {		
		String result = userService.validateVerificationToken(token);
		
		if (result.equalsIgnoreCase(AppConstants.VALID_TOKEN)) return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse(AppConstants.TOKEN_VALIDATED));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(AppConstants.TOKEN_NOT_FOUND));
	}
	
	private String applicationURL(HttpServletRequest request) {
		return "http://" + 
				request.getServerName() + 
				":" +
				request.getServerPort() + 
				request.getContextPath() + 
				this.getClass().getAnnotation(RequestMapping.class).value()[0];
	}
	
	private User convertToEntity(UserDto dto) {
		return modelMapper.map(dto, User.class);
	}
}
