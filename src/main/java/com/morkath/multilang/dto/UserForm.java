package com.morkath.multilang.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserForm {
	
	private Long id;

	@NotBlank(message = "Username không được để trống")
	private String username;

	@NotBlank(message = "Email không được để trống")
	private String email;

	@NotBlank(message = "Password không được để trống")
	private String password;

	@NotNull(message = "Status không được để trống")
	private int status;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
