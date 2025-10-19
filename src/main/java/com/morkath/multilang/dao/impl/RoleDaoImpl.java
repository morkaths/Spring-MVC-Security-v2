package com.morkath.multilang.dao.impl;

import org.springframework.stereotype.Repository;

import com.morkath.multilang.core.BaseDaoImpl;
import com.morkath.multilang.dao.RoleDao;
import com.morkath.multilang.entity.RoleEntity;

@Repository
public class RoleDaoImpl extends BaseDaoImpl<RoleEntity, Long> implements RoleDao {
	
	public RoleDaoImpl() {
		super(RoleEntity.class);
	}
	
	@Override
	public RoleEntity findByCode(String code) {
		return findOneByField("code", code);
	}

}
