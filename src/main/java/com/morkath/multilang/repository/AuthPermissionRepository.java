package com.morkath.multilang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morkath.multilang.entity.AuthPermissionEntity;

public interface AuthPermissionRepository extends JpaRepository<AuthPermissionEntity, Long> {

}
