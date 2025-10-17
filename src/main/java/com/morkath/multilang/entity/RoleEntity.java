package com.morkath.multilang.entity;

import javax.persistence.*;

import com.morkath.multilang.core.BaseEntity;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {
    
    @Column(nullable = false, unique = true)
    private String name;

    public RoleEntity() {}

    public RoleEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
