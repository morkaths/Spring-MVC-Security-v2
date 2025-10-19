package com.morkath.multilang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morkath.multilang.dto.ProductDTO;
import com.morkath.multilang.entity.ProductCategoryTranslationEntity;
import com.morkath.multilang.entity.ProductEntity;
import com.morkath.multilang.entity.ProductTranslationEntity;
import com.morkath.multilang.repository.ProductRepository;
import com.morkath.multilang.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts(String lang) {
        List<ProductEntity> products = productRepository.findAllWithTranslation(lang);
        List<ProductDTO> result = new ArrayList<>();

        for (ProductEntity p : products) {
            ProductTranslationEntity productTranslation = null;
            if (p.getTranslations() != null) {
                productTranslation = p.getTranslations().stream()
                        .filter(t -> t.getLanguageID().equals(lang))
                        .findFirst().orElse(null);
            }

            ProductCategoryTranslationEntity categoryTranslation = null;
            if (p.getProductCategory() != null && p.getProductCategory().getTranslations() != null) {
                categoryTranslation = p.getProductCategory().getTranslations().stream()
                        .filter(t -> t.getLanguageID().equals(lang))
                        .findFirst().orElse(null);
            }

            String productName = productTranslation != null ? productTranslation.getProductName() : "No name";
            String productDesc = productTranslation != null ? productTranslation.getProductDescription() : "No description";
            String categoryName = categoryTranslation != null ? categoryTranslation.getCategoryName() : "No category";

            result.add(new ProductDTO(
                    p.getProductID(),
                    productName,
                    productDesc,
                    p.getPrice(),
                    categoryName,
                    p.getWeight()
            ));
        }
        return result;
    }

    @Override
    public ProductEntity getProductById(int id, String lang) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductEntity createProduct(ProductEntity product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ProductEntity updateProduct(ProductEntity product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

}
