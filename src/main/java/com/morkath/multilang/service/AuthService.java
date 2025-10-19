package com.morkath.multilang.service;

public interface AuthService {
	public String register(String username, String password, String email);
	public String login(String username, String password);
	
}
