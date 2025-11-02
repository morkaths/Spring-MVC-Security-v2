package com.morkath.multilang.service.impl;

import com.morkath.multilang.entity.AuthRoleEntity;
import com.morkath.multilang.entity.AuthUserEntity;
import com.morkath.multilang.repository.UserRepository;
import com.morkath.multilang.constant.SystemConstant;
import com.morkath.multilang.dto.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthUserEntity user = userRepository.findOneByUsernameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		// Get role
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (AuthRoleEntity role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUser myUser = new MyUser(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
		myUser.setFullName(user.getFullName());
		return myUser;
	}
}
