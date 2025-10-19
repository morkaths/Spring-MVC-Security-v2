package com.morkath.multilang.service;

import java.util.List;

import com.morkath.multilang.dto.UserForm;
import com.morkath.multilang.entity.AuthUserEntity;

public interface UserService {
	List<AuthUserEntity> getAllUsers();
	AuthUserEntity getUserById(Long id);
	AuthUserEntity getUserByUsername(String username);
	AuthUserEntity createUser(UserForm user);
	AuthUserEntity updateUser(UserForm user);
	void deleteUser(Long id);
}
