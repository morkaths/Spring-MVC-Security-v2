package com.morkath.multilang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.morkath.multilang.constant.QueryConstant;
import com.morkath.multilang.entity.AuthUserEntity;

public interface AuthUserRepository extends JpaRepository<AuthUserEntity, Long> {
	AuthUserEntity findByUsername(String username);

	AuthUserEntity findByEmail(String email);

	AuthUserEntity findOneByUsernameAndStatus(String username, int status);

	@Query(QueryConstant.FIND_BY_USERNAME_OR_EMAIL)
	AuthUserEntity findByUsernameOrEmail(String identifier);
}
