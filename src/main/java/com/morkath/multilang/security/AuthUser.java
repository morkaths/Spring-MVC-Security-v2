package com.morkath.multilang.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.morkath.multilang.entity.AuthUserEntity;

public class AuthUser extends User {
	private static final long serialVersionUID = 1L;
	private AuthUserEntity user;

	public AuthUser(AuthUserEntity user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getUsername(), user.getPassword(), user.getStatus()  == 1, true, true, true, authorities);
		this.user = user;
	}
	
	public AuthUserEntity getUser() {
		return user;
	}

	public void setUser(AuthUserEntity user) {
		this.user = user;
	}
	
}
