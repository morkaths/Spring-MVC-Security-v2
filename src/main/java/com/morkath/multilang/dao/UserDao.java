package com.morkath.multilang.dao;

import com.morkath.multilang.core.BaseDao;
import com.morkath.multilang.entity.AuthUserEntity;

public interface UserDao extends BaseDao<AuthUserEntity, Long> {
	AuthUserEntity findByUsername(String username);
	AuthUserEntity findByEmail(String email);
}
