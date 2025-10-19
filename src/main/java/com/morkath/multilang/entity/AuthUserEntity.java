package com.morkath.multilang.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.morkath.multilang.core.BaseEntity;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
	
	@Column(nullable = false, unique = true)
    private String username;
	
	@Column(nullable = false)
    private String password;
	
	@Column(nullable = false, unique = true)
    private String email;
	
	@Column(nullable = false)
    private int status;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roles = new ArrayList<>();
    
    public UserEntity() {}
    
    public UserEntity(String username, String password, String email, int status) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.status = status;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
    
    
}
