package com.morkath.multilang.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
        .authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll()  // Allow all requests
        )
        .csrf().disable()  // Disable CSRF for simplicity
        .formLogin().disable()  // Disable Spring Security form login
        .logout().disable();   // Disable Spring Security logout
    
    return http.build();
	}
	
}