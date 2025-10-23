package com.tanzeem.product_service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

//@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	private static final String[] WHITE_LIST_URLS = {
			"/product-service/**",
			"/actuator/**"
			
	};
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	 * throws Exception { http .csrf(csrf -> csrf.disable())
	 * .authorizeHttpRequests(auth ->
	 * auth.requestMatchers(WHITE_LIST_URLS).permitAll()
	 * .anyRequest().authenticated() ); //.httpBasic(Customizer.withDefaults());
	 * 
	 * return http.build(); }
	 */
}
