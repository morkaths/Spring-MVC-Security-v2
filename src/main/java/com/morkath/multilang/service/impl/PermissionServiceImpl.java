package com.morkath.multilang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morkath.multilang.entity.AuthPermissionEntity;
import com.morkath.multilang.repository.AuthPermissionRepository;
import com.morkath.multilang.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private AuthPermissionRepository permissionRepository;

    @Override
    public List<AuthPermissionEntity> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public AuthPermissionEntity getPermissionById(Long id) {
        return permissionRepository.findById(id).orElse(null);
    }

    @Override
    public AuthPermissionEntity createPermission(AuthPermissionEntity permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public AuthPermissionEntity updatePermission(AuthPermissionEntity permission) {
        if (permission.getId() == null || !permissionRepository.existsById(permission.getId())) {
            return null;
        }
        return permissionRepository.save(permission);
    }

    @Override
    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }
}