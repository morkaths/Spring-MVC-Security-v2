package com.morkath.multilang.model;

import java.math.BigDecimal;

public class Product {
	private int productID;
	private BigDecimal price;
	private double weight;
	private int productCategoryID;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productID, BigDecimal price, double weight, int productCategoryID) {
		super();
		this.productID = productID;
		this.price = price;
		this.weight = weight;
		this.productCategoryID = productCategoryID;
	}
	
	public int getProductID() {
		return productID;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public int getProductCategoryID() {
		return productCategoryID;
	}
	
	public void setProductCategoryID(int productCategoryID) {
		this.productCategoryID = productCategoryID;
	}
	
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", price=" + price + ", weight=" + weight + ", productCategoryID="
				+ productCategoryID + "]";
	}
	
	
}
