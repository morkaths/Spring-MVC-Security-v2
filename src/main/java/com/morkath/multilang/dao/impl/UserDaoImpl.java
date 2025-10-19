package com.morkath.multilang.dao.impl;

import org.springframework.stereotype.Repository;

import com.morkath.multilang.core.BaseDaoImpl;
import com.morkath.multilang.dao.UserDao;
import com.morkath.multilang.entity.AuthUserEntity;

@Repository
public class UserDaoImpl extends BaseDaoImpl<AuthUserEntity, Long> implements UserDao {
	
	public UserDaoImpl() {
        super(AuthUserEntity.class);
    }
	
	@Override
    public AuthUserEntity findByUsername(String username) {
    	return findOneByField("username", username);
    }

    @Override
    public AuthUserEntity findByEmail(String email) {
    	return findOneByField("email", email);
    }
	
    @Override
    public AuthUserEntity save(AuthUserEntity user) {
		return super.save(user);
	}
	
}
