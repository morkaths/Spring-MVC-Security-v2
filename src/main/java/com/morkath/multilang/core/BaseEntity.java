package com.morkath.multilang.core;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	
	@CreatedDate
	@Column(name = "CreatedAt", nullable = true, updatable = false)
    private LocalDateTime createdAt;
    
	@LastModifiedDate
    @Column(name = "ModifiedAt", nullable = true)
    private LocalDateTime modifiedAt;
	
	@LastModifiedBy
	@Column(name = "ModifiedBy", nullable = true, length = 100)
	private String modifiedBy;
	
	public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getModifiedAt() {
		return modifiedAt;
    }

	public String getModifiedBy() {
		return modifiedBy;
	}
    
}
