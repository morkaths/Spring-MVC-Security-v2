package com.morkath.multilang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morkath.multilang.dao.UserDao;
import com.morkath.multilang.dto.UserForm;
import com.morkath.multilang.entity.UserEntity;
import com.morkath.multilang.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserEntity> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public UserEntity getUserById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public UserEntity getUserByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public UserEntity createUser(UserForm userForm) {
		UserEntity user = new UserEntity();
		user.setUsername(userForm.getUsername());
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setStatus(userForm.getStatus());
		return userDao.save(user);
	}

	@Override
	public UserEntity updateUser(UserForm userForm) {
		UserEntity user = userDao.findById(userForm.getId());
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
