package com.morkath.multilang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.morkath.multilang.entity.AuthUserEntity;

public interface UserRepository extends JpaRepository<AuthUserEntity, Long> {
	AuthUserEntity findByUsername(String username);
	AuthUserEntity findByEmail(String email);
	AuthUserEntity findOneByUsernameAndStatus(String username, int status);
}
