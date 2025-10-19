package com.morkath.multilang.entity;

import javax.persistence.*;

import com.morkath.multilang.core.BaseEntity;

@Entity
@Table(name = "product_translation")
@IdClass(ProductTranslationPK.class)
public class ProductTranslationEntity extends BaseEntity {

	@Id
	@Column(name = "ProductID")
	private Integer productID;

	@Id
	@Column(name = "LanguageID", length = 2)
	private String languageID;

	@Column(name = "ProductName", length = 100, nullable = false)
	private String productName;

	@Column(name = "ProductDescription", length = 100)
	private String productDescription;

	@ManyToOne
	@JoinColumn(name = "ProductID", insertable = false, updatable = false)
	private ProductEntity product;

	@ManyToOne
	@JoinColumn(name = "LanguageID", insertable = false, updatable = false)
	private LanguageEntity language;

	public ProductTranslationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductTranslationEntity(Integer productID, String languageID, String productName,
			String productDescription) {
		super();
		this.productID = productID;
		this.languageID = languageID;
		this.productName = productName;
		this.productDescription = productDescription;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getLanguageID() {
		return languageID;
	}

	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public LanguageEntity getLanguage() {
		return language;
	}

	public void setLanguage(LanguageEntity language) {
		this.language = language;
	}

}
