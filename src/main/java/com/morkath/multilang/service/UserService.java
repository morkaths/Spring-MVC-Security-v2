package com.morkath.multilang.service;

import java.util.List;

import com.morkath.multilang.dto.AuthUserDTO;

public interface UserService {
	List<AuthUserDTO> getAllUsers();
	AuthUserDTO getCurrentUser();
	AuthUserDTO getUserById(Long id);
	AuthUserDTO getUserByUsername(String username);
	AuthUserDTO createUser(AuthUserDTO user);
	AuthUserDTO updateUser(AuthUserDTO user);
	void deleteUser(Long id);
}
