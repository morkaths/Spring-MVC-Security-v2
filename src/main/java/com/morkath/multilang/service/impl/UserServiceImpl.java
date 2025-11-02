package com.morkath.multilang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.morkath.multilang.dto.UserForm;
import com.morkath.multilang.entity.AuthUserEntity;
import com.morkath.multilang.repository.AuthUserRepository;
import com.morkath.multilang.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AuthUserRepository userRepository;

	@Override
	public List<AuthUserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public AuthUserEntity getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public AuthUserEntity getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public AuthUserEntity createUser(UserForm userForm) {
		AuthUserEntity user = new AuthUserEntity();
		user.setUsername(userForm.getUsername());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setStatus(userForm.getStatus());
		return userRepository.save(user);
	}

	@Override
	public AuthUserEntity updateUser(UserForm userForm) {
		AuthUserEntity user = userRepository.findById(userForm.getId()).orElse(null);
		if (user != null) {
			user.setUsername(userForm.getUsername());
			user.setEmail(userForm.getEmail());
			user.setPassword(userForm.getPassword());
			user.setStatus(userForm.getStatus());
			return userRepository.save(user);
		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public AuthUserEntity getCurrentUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return userRepository.findByUsername(username);
	}

}
