package com.morkath.multilang.service;

import java.util.List;

import com.morkath.multilang.dto.AuthRoleDTO;

public interface RoleService {
    List<AuthRoleDTO> getAllRoles();
    AuthRoleDTO getRoleById(Long id);
    AuthRoleDTO createRole(AuthRoleDTO roleDTO);
    AuthRoleDTO updateRole(AuthRoleDTO roleDTO);
    void deleteRole(Long id);
}
