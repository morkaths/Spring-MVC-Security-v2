package com.morkath.multilang.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morkath.multilang.dao.UserDao;
import com.morkath.multilang.entity.UserEntity;
import com.morkath.multilang.service.AuthService;
import com.morkath.multilang.util.PasswordUtil;
import com.morkath.multilang.util.JwtUtil;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public String register(String username, String password, String email) {
	    if (userDao.findByUsername(username) != null) {
	        return null; // Username already exists
	    }
	    if (userDao.findByEmail(email) != null) {
	        return null; // Email already exists
	    }
	    UserEntity user = new UserEntity();
	    user.setUsername(username);
	    user.setPassword(PasswordUtil.hash(password));
	    user.setEmail(email);
	    user.setStatus(1);
	    
	    UserEntity savedUser = userDao.save(user);
	    if (savedUser == null) {
	        return null;
	    }
	    return JwtUtil.generateToken(username);
	}

	@Override
	public String login(String username, String password) {
	    UserEntity user = userDao.findByUsername(username);
	    if (user != null && PasswordUtil.matches(password, user.getPassword())) {
	    	return JwtUtil.generateToken(user.getUsername());
	    }
	    return null;
	}

}
