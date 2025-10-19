package com.morkath.multilang.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProductCategoryTranslationPK implements Serializable {
	
	private Integer productCategoryID;
	private String languageID;
	
	public ProductCategoryTranslationPK() {
	}

	public ProductCategoryTranslationPK(Integer productCategoryID, String languageID) {
		super();
		this.productCategoryID = productCategoryID;
		this.languageID = languageID;
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
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoryTranslationPK that = (ProductCategoryTranslationPK) o;
        return Objects.equals(productCategoryID, that.productCategoryID) &&
               Objects.equals(languageID, that.languageID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCategoryID, languageID);
    }
	
	
}
