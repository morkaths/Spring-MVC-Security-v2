package com.morkath.multilang.dto;

import java.math.BigDecimal;

public class ProductDTO {
	private Integer id;
	private String name;
	private String description;
	private BigDecimal price;
	private String categoryName;
	private double weight;

	public ProductDTO(Integer id, String name, String description, BigDecimal price, String categoryName,
			double weight) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categoryName = categoryName;
		this.weight = weight;
	}

	// Getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}