package com.morkath.multilang.model;

public class ProductCategoryTranslation {
	private int productCategoryID;
	private String languageID;
	private String categoryName;
	
	public ProductCategoryTranslation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductCategoryTranslation(int productCategoryID, String languageID, String categoryName) {
		super();
		this.productCategoryID = productCategoryID;
		this.languageID = languageID;
		this.categoryName = categoryName;
	}

	public int getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(int productCategoryID) {
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

	@Override
	public String toString() {
		return "ProductCategoryTranslation [productCategoryID=" + productCategoryID + ", languageID=" + languageID
				+ ", categoryName=" + categoryName + "]";
	}
	
}
