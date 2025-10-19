package com.morkath.multilang.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.morkath.multilang.core.BaseEntity;

@Entity
@Table(name = "product")
public class ProductEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer productID;

    @Column(name = "Price", precision = 10, scale = 2, nullable = false)
    private java.math.BigDecimal price;

    @Column(name = "Weight", nullable = false)
    private double weight;

    @ManyToOne
    @JoinColumn(name = "ProductCategoryID", referencedColumnName = "ProductCategoryID", nullable = false)
    private ProductCategoryEntity productCategory;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<ProductTranslationEntity> translations = new HashSet<>();

    public ProductEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProductEntity(BigDecimal price, double weight, ProductCategoryEntity productCategory) {
        super();
        this.price = price;
        this.weight = weight;
        this.productCategory = productCategory;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public java.math.BigDecimal getPrice() {
        return price;
    }

    public void setPrice(java.math.BigDecimal price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Set<ProductTranslationEntity> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<ProductTranslationEntity> translations) {
        this.translations = translations;
    }

    public ProductCategoryEntity getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategoryEntity productCategory) {
        this.productCategory = productCategory;
    }

}
