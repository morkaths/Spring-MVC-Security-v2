package com.morkath.multilang.service;

import java.util.List;

import com.morkath.multilang.dto.UserForm;
import com.morkath.multilang.entity.UserEntity;

public interface UserService {
	public List<UserEntity> getAllUsers();
	public UserEntity getUserById(Long id);
	public UserEntity getUserByUsername(String username);
	public UserEntity createUser(UserForm user);
	public UserEntity updateUser(UserForm user);
	public void deleteUser(Long id);
}
