package com.morkath.multilang.model;

public class ProductTranslation {
	private int productID;
	private String languageID;
	private String productName;
	private String productDescription;
	
	public ProductTranslation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductTranslation(int productID, String languageID, String productName, String productDescription) {
		super();
		this.productID = productID;
		this.languageID = languageID;
		this.productName = productName;
		this.productDescription = productDescription;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
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

	@Override
	public String toString() {
		return "ProductTranslation [productID=" + productID + ", languageID=" + languageID + ", productName="
				+ productName + ", productDescription=" + productDescription + "]";
	}
	
}
