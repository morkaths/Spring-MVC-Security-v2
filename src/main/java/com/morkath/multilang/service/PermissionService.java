package com.morkath.multilang.service;

import java.util.List;

import com.morkath.multilang.entity.AuthPermissionEntity;

public interface PermissionService {
    List<AuthPermissionEntity> getAllPermissions();
    AuthPermissionEntity getPermissionById(Long id);
    AuthPermissionEntity createPermission(AuthPermissionEntity permission);
    AuthPermissionEntity updatePermission(AuthPermissionEntity permission);
    void deletePermission(Long id);
}
