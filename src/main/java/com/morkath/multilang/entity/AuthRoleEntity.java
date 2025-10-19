package com.morkath.multilang.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.morkath.multilang.core.BaseEntity;

@Entity
@Table(name = "auth_role")
public class AuthRoleEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RoleID")
	private Long id;

	@Column(name = "Code", nullable = false, unique = true)
	private String code;

	@Column(name = "Name", nullable = false)
	private String name;

	@ManyToMany
	@JoinTable(name = "auth_role_permission", joinColumns = @JoinColumn(name = "RoleID"), inverseJoinColumns = @JoinColumn(name = "PermissionID"))
	private Set<AuthPermissionEntity> permissions = new HashSet<>();

	@ManyToMany(mappedBy = "roles")
	private Set<AuthUserEntity> users = new HashSet<>();

	public AuthRoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthRoleEntity(String code, String name) {
		super();
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

	public Set<AuthPermissionEntity> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<AuthPermissionEntity> permissions) {
		this.permissions = permissions;
	}

	public Set<AuthUserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<AuthUserEntity> users) {
		this.users = users;
	}

}
