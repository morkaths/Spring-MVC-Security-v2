package com.morkath.multilang.entity;

import java.util.List;

import javax.persistence.*;

import com.morkath.multilang.core.BaseEntity;

@Entity
@Table(name = "product_category")
public class ProductCategoryEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductCategoryID")
	private Integer productCategoryID;

	@Column(name = "CanBeShipped", nullable = false)
	private boolean canBeShipped;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductEntity> products;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductCategoryTranslationEntity> translations;

	public ProductCategoryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductCategoryEntity(boolean canBeShipped) {
		super();
		this.canBeShipped = canBeShipped;
	}

	public Integer getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(Integer productCategoryID) {
		this.productCategoryID = productCategoryID;
	}

	public boolean isCanBeShipped() {
		return canBeShipped;
	}

	public void setCanBeShipped(boolean canBeShipped) {
		this.canBeShipped = canBeShipped;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public List<ProductCategoryTranslationEntity> getTranslations() {
		return translations;
	}

	public void setTranslations(List<ProductCategoryTranslationEntity> translations) {
		this.translations = translations;
	}

}