package com.morkath.multilang.dao.impl;

import org.springframework.stereotype.Repository;

import com.morkath.multilang.core.BaseDaoImpl;
import com.morkath.multilang.dao.RoleDao;
import com.morkath.multilang.entity.AuthRoleEntity;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<AuthRoleEntity, Long> implements RoleDao {
	
	public RoleDaoImpl() {
		super(AuthRoleEntity.class);
	}
	
	@Override
	public AuthRoleEntity findByCode(String code) {
		return findOneByField("code", code);
	}

}
