package com.morkath.multilang.model;

public class ProductCategory {
	private int productCategoryID;
	private boolean canBeShipped;
	
	public ProductCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductCategory(int productCategoryID, boolean canBeShipped) {
		super();
		this.productCategoryID = productCategoryID;
		this.canBeShipped = canBeShipped;
	}

	public int getProductCategoryID() {
		return productCategoryID;
	}

	public void setProductCategoryID(int productCategoryID) {
		this.productCategoryID = productCategoryID;
	}

	public boolean isCanBeShipped() {
		return canBeShipped;
	}

	public void setCanBeShipped(boolean canBeShipped) {
		this.canBeShipped = canBeShipped;
	}

	@Override
	public String toString() {
		return "ProductCategory [productCategoryID=" + productCategoryID + ", canBeShipped=" + canBeShipped + "]";
	}
	
}
