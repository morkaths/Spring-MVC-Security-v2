package com.morkath.multilang.entity;

import javax.persistence.*;

import com.morkath.multilang.core.BaseEntity;

@Entity
@Table(name = "product_category_translation")
@IdClass(ProductCategoryTranslationPK.class)
public class ProductCategoryTranslationEntity extends BaseEntity {

	@Id
	@Column(name = "ProductCategoryID")
	private Integer productCategoryID;

	@Id
	@Column(name = "LanguageID", length = 2)
	private String languageID;

	@Column(name = "CategoryName", length = 100, nullable = false)
	private String categoryName;

	@ManyToOne
	@JoinColumn(name = "ProductCategoryID", insertable = false, updatable = false)
	private ProductCategoryEntity productCategory;

	@ManyToOne
	@JoinColumn(name = "LanguageID", insertable = false, updatable = false)
	private LanguageEntity language;

	public ProductCategoryTranslationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductCategoryTranslationEntity(Integer productCategoryID, String languageID, String categoryName) {
		super();
		this.productCategoryID = productCategoryID;
		this.languageID = languageID;
		this.categoryName = categoryName;
	}

	public Integer getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(Integer productCategoryID) {
		this.productCategoryID = productCategoryID;
	}

	public String getLanguageID() {
		return languageID;
	}

	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public ProductCategoryEntity getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategoryEntity productCategory) {
		this.productCategory = productCategory;
	}

	public LanguageEntity getLanguage() {
		return language;
	}

	public void setLanguage(LanguageEntity language) {
		this.language = language;
	}

}
