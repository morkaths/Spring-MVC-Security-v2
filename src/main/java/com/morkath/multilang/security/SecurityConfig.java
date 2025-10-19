package com.morkath.multilang.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@SuppressWarnings("deprecation")
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
            .antMatchers("/admin/**").authenticated()
            .anyRequest().permitAll()
        .and()
        .formLogin()
            .loginPage("/auth/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .defaultSuccessUrl("/", false)
            .permitAll()
        .and()
        .logout()
            .permitAll()
        .and()
        .sessionManagement()
            .maximumSessions(1)
            .maxSessionsPreventsLogin(false);

    return http.build();
    }
	
}