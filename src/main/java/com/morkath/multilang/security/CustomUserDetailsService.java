package com.morkath.multilang.security;

import com.morkath.multilang.constant.SystemConstant;
import com.morkath.multilang.entity.AuthRoleEntity;
import com.morkath.multilang.entity.AuthUserEntity;
import com.morkath.multilang.repository.AuthUserRepository;

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
	private AuthUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthUserEntity user = userRepository.findOneByUsernameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		// Get role
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (AuthRoleEntity role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));
			role.getPermissions().forEach(permission -> {
				authorities.add(new SimpleGrantedAuthority(permission.getCode()));
			});
		}
		return new AuthUser(user, authorities);
	}
}
