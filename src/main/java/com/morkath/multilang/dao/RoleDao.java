package com.morkath.multilang.dao;

import com.morkath.multilang.core.BaseDao;
import com.morkath.multilang.entity.AuthRoleEntity;

public interface RoleDao extends BaseDao<AuthRoleEntity, Long> {
	AuthRoleEntity findByCode(String code);
}
