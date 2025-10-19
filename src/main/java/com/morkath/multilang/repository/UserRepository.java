package com.morkath.multilang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morkath.multilang.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
	UserEntity findByEmail(String email);
}
