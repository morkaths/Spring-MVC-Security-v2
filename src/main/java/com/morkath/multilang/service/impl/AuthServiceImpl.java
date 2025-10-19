package com.morkath.multilang.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morkath.multilang.entity.AuthRoleEntity;
import com.morkath.multilang.entity.AuthUserEntity;
import com.morkath.multilang.repository.RoleRepository;
import com.morkath.multilang.repository.UserRepository;
import com.morkath.multilang.service.AuthService;
import com.morkath.multilang.util.PasswordUtil;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
    public boolean register(String username, String password, String email) {
        if (userRepository.findByUsername(username) != null) {
            return false; // Username already exists
        }
        if (userRepository.findByEmail(email) != null) {
            return false; // Email already exists
        }
        AuthUserEntity user = new AuthUserEntity();
        user.setUsername(username);
        user.setPassword(PasswordUtil.hash(password));
        user.setEmail(email);
        user.setStatus(1);
        
        AuthRoleEntity userRole = roleRepository.findByCode("USER");
        if (userRole != null) {
			user.getRoles().add(userRole);
		}

        AuthUserEntity savedUser = userRepository.save(user);
        return savedUser != null;
    }

}
