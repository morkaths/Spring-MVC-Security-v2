package com.morkath.multilang.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.morkath.multilang.core.BaseEntity;

@Entity
@Table(name = "auth_user")
public class AuthUserEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserID")
	private Long id;

	@Column(name = "Username", nullable = false, unique = true, length = 100)
	private String username;

	@Column(name = "Password", nullable = false)
	private String password;

	@Column(name = "Email", nullable = false, unique = true)
	private String email;

	@Column(name = "FullName")
	private String fullName;

	@Column(name = "Status", nullable = false)
	private int status;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "UserID"), inverseJoinColumns = @JoinColumn(name = "RoleID"))
	private Set<AuthRoleEntity> roles = new HashSet<>();

	public AuthUserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthUserEntity(String username, String password, String email, String fullName, int status) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<AuthRoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<AuthRoleEntity> roles) {
		this.roles = roles;
	}

}
