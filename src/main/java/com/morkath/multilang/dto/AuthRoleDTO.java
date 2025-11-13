package com.morkath.multilang.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AuthRoleDTO {
    
    private Long id;
    
    @NotBlank(message = "Mã vai trò là bắt buộc")
    @Size(max = 50, message = "Mã vai trò không được vượt quá 50 ký tự")
    @Pattern(regexp = "^[a-z0-9_]+$", message = "Mã vai trò chỉ được chứa chữ thường, số và dấu gạch dưới")
    private String code;
    
    @NotBlank(message = "Tên vai trò là bắt buộc")
    @Size(max = 100, message = "Tên vai trò không được vượt quá 100 ký tự")
    private String name;
    
    private Set<Long> permissionIds = new HashSet<>();
    private Set<AuthPermissionDTO> permissions = new HashSet<>();

    public AuthRoleDTO() {
    }

    public AuthRoleDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(Set<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }

    public Set<AuthPermissionDTO> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<AuthPermissionDTO> permissions) {
        this.permissions = permissions;
    }
}