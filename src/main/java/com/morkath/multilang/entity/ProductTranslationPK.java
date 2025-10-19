package com.morkath.multilang.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProductTranslationPK implements Serializable {

	private Integer productID;
	private String languageID;

	public ProductTranslationPK() {
	}

	public ProductTranslationPK(Integer productID, String languageID) {
		this.productID = productID;
		this.languageID = languageID;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ProductTranslationPK that = (ProductTranslationPK) o;
		return Objects.equals(productID, that.productID) && Objects.equals(languageID, that.languageID);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productID, languageID);
	}
}