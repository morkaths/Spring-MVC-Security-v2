package com.morkath.multilang.service;

public interface AuthService {
	/**
	 * Register a new user
	 * @param username - Desired username
	 * @param password - Desired password
	 * @param email - User email
	 * @return True if registration is successful, false otherwise
	 */
	boolean register(String username, String password, String email);
}
