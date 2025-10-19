package com.morkath.multilang.entity;

import javax.persistence.*;

import com.morkath.multilang.core.BaseEntity;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "auth_permission")
public class AuthPermissionEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PermissionID")
	private Long id;

	@Column(name = "Code", nullable = false, unique = true, length = 100)
	private String code;

	@Column(name = "Name", nullable = false, length = 255)
	private String name;

	@ManyToMany(mappedBy = "permissions")
	private Set<AuthRoleEntity> roles = new HashSet<>();

	public AuthPermissionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthPermissionEntity(String code, String name, Set<AuthRoleEntity> roles) {
		super();
		this.code = code;
		this.name = name;
		this.roles = roles;
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

	public Set<AuthRoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<AuthRoleEntity> roles) {
		this.roles = roles;
	}

}
