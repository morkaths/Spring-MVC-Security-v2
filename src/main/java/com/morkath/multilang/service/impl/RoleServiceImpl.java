package com.morkath.multilang.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morkath.multilang.dto.AuthRoleDTO;
import com.morkath.multilang.entity.AuthPermissionEntity;
import com.morkath.multilang.entity.AuthRoleEntity;
import com.morkath.multilang.repository.AuthPermissionRepository;
import com.morkath.multilang.repository.AuthRoleRepository;
import com.morkath.multilang.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private AuthRoleRepository roleRepository;

    @Autowired
    private AuthPermissionRepository permissionRepository;

    @Override
    public List<AuthRoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuthRoleDTO getRoleById(Long id) {
        return roleRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    @Override
    public AuthRoleDTO createRole(AuthRoleDTO roleDTO) {
        AuthRoleEntity entity = new AuthRoleEntity();
        entity.setCode(roleDTO.getCode());
        entity.setName(roleDTO.getName());
        if (roleDTO.getPermissionIds() != null && !roleDTO.getPermissionIds().isEmpty()) {
            List<AuthPermissionEntity> permissions = permissionRepository.findAllById(roleDTO.getPermissionIds());
            entity.setPermissions(new HashSet<>(permissions));
        }
        AuthRoleEntity saved = roleRepository.save(entity);
        return toDTO(saved);
    }

    @Override
    public AuthRoleDTO updateRole(AuthRoleDTO roleDTO) {
        AuthRoleEntity entity = roleRepository.findById(roleDTO.getId()).orElse(null);
        if (entity == null)
            return null;
        entity.setCode(roleDTO.getCode());
        entity.setName(roleDTO.getName());
        if (roleDTO.getPermissionIds() != null) {
            List<AuthPermissionEntity> permissions = permissionRepository.findAllById(roleDTO.getPermissionIds());
            entity.setPermissions(new HashSet<>(permissions));
        }
        AuthRoleEntity saved = roleRepository.save(entity);
        return toDTO(saved);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    private AuthRoleDTO toDTO(AuthRoleEntity entity) {
        AuthRoleDTO dto = new AuthRoleDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        if (entity.getPermissions() != null) {
            dto.setPermissionIds(entity.getPermissions().stream()
                    .map(AuthPermissionEntity::getId)
                    .collect(Collectors.toSet()));
            dto.setPermissions(entity.getPermissions().stream()
                    .map(p -> new com.morkath.multilang.dto.AuthPermissionDTO(p.getId(), p.getCode(), p.getName()))
                    .collect(Collectors.toSet()));
        }
        return dto;
    }
}