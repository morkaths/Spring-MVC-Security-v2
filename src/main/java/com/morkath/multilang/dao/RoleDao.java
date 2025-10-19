package com.morkath.multilang.dao;

import com.morkath.multilang.core.BaseDao;
import com.morkath.multilang.entity.RoleEntity;

public interface RoleDao extends BaseDao<RoleEntity, Long> {
	RoleEntity findByCode(String code);
}
