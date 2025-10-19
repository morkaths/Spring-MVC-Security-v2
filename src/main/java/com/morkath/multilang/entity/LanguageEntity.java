package com.morkath.multilang.entity;

import javax.persistence.*;

import com.morkath.multilang.core.BaseEntity;

@Entity
@Table(name = "languages")
public class LanguageEntity extends BaseEntity {
	
	@Column(nullable = false, unique = true)
	private String language;

	public LanguageEntity() {}

	public LanguageEntity(String language) {
		super();
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
