package com.morkath.multilang.entity;

import java.util.List;

import javax.persistence.*;

import com.morkath.multilang.core.BaseEntity;

@Entity
@Table(name = "language")
public class LanguageEntity extends BaseEntity {

	@Id
	@Column(name = "LanguageID", length = 2)
	private String languageID;

	@Column(name = "Language", length = 20, nullable = false)
	private String language;

	@OneToMany(mappedBy = "language", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductTranslationEntity> productTranslations;

	@OneToMany(mappedBy = "language", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductCategoryTranslationEntity> productCategoryTranslations;

	public LanguageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LanguageEntity(String languageID, String language) {
		super();
		this.languageID = languageID;
		this.language = language;
	}

	public String getLanguageID() {
		return languageID;
	}

	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<ProductTranslationEntity> getProductTranslations() {
		return productTranslations;
	}

	public void setProductTranslations(List<ProductTranslationEntity> productTranslations) {
		this.productTranslations = productTranslations;
	}

	public List<ProductCategoryTranslationEntity> getProductCategoryTranslations() {
		return productCategoryTranslations;
	}

	public void setProductCategoryTranslations(List<ProductCategoryTranslationEntity> productCategoryTranslations) {
		this.productCategoryTranslations = productCategoryTranslations;
	}

}
