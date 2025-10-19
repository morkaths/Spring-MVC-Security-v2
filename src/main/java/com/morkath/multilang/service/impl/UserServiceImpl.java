package com.morkath.multilang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morkath.multilang.dao.UserDao;
import com.morkath.multilang.dto.UserForm;
import com.morkath.multilang.entity.AuthUserEntity;
import com.morkath.multilang.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<AuthUserEntity> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public AuthUserEntity getUserById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public AuthUserEntity getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public AuthUserEntity createUser(UserForm userForm) {
		AuthUserEntity user = new AuthUserEntity();
		user.setUsername(userForm.getUsername());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setStatus(userForm.getStatus());
		return userDao.save(user);
	}

	@Override
	public AuthUserEntity updateUser(UserForm userForm) {
		AuthUserEntity user = userDao.findById(userForm.getId());
		if (user != null) {
			user.setUsername(userForm.getUsername());
			user.setEmail(userForm.getEmail());
			user.setPassword(userForm.getPassword());
			user.setStatus(userForm.getStatus());
			return userDao.update(user);
		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userDao.delete(id);
	}
	
}
