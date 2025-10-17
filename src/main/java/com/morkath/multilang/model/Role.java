package com.morkath.multilang.model;

import java.util.List;

public class Role {
	private int id;
	private String code;
	private String name;
	private List<Permission> permissions;
	
	public Role() {}
	
	public Role(int id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public List<Permission> getPermissions() { return permissions; }
	public void setPermissions(List<Permission> permissions) { this.permissions = permissions; }
}
