package com.morkath.multilang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.morkath.multilang.entity.AuthRoleEntity;

public interface AuthRoleRepository extends JpaRepository<AuthRoleEntity, Long> {
	AuthRoleEntity findByCode(String code);
	AuthRoleEntity findByName(String name);
}
