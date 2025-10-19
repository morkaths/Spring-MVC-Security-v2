package com.morkath.multilang.dao.impl;

import org.springframework.stereotype.Repository;

import com.morkath.multilang.core.BaseDaoImpl;
import com.morkath.multilang.dao.UserDao;
import com.morkath.multilang.entity.UserEntity;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserEntity, Long> implements UserDao {
	
	public UserDaoImpl() {
        super(UserEntity.class);
    }
	
	@Override
    public UserEntity findByUsername(String username) {
    	return findOneByField("username", username);
    }

    @Override
    public UserEntity findByEmail(String email) {
    	return findOneByField("email", email);
    }
	
    @Override
    public UserEntity save(UserEntity user) {
		return super.save(user);
	}
	
}
