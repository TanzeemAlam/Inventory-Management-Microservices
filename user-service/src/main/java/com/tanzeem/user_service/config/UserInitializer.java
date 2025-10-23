package com.tanzeem.user_service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tanzeem.user_service.entity.User;
import com.tanzeem.user_service.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserInitializer {

    private static final Logger logger = LoggerFactory.getLogger(UserInitializer.class);
    
	@Bean
	public CommandLineRunner createAdminUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (userRepository.findByUsername("admin").isEmpty()) {
				User admin = new User();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("admin"));
				admin.setRole("ADMIN");
				admin.setEnabled(true);
				
				userRepository.save(admin);
				
				logger.info("Default admin user created...");
			}
			
			if (userRepository.findByUsername("user").isEmpty()) {
				User user = new User();
				user.setUsername("user");
				user.setPassword(passwordEncoder.encode("user"));
				user.setRole("USER");
				user.setEnabled(true);
				
				
				userRepository.save(user);
				
				logger.info("Default user created...");
			}
		};
	}
}

