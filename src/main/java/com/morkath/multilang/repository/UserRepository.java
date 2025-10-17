package com.morkath.multilang.repository;

import com.morkath.multilang.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername(String username);
    UserEntity findByEmail(String email);
}
