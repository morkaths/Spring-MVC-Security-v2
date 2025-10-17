package com.morkath.multilang.dao;

import com.morkath.multilang.core.BaseDao;
import com.morkath.multilang.entity.UserEntity;

public interface UserDao extends BaseDao<UserEntity, Long> {
	UserEntity findByUsername(String username);
	UserEntity findByEmail(String email);
}
