package com.morkath.multilang.service;

import java.util.List;

import com.morkath.multilang.dto.ProductDTO;
import com.morkath.multilang.entity.ProductEntity;

public interface ProductService {
	List<ProductDTO> getAllProducts(String lang);
	ProductEntity getProductById(int id, String lang);
	ProductEntity createProduct(ProductEntity product);
	ProductEntity updateProduct(ProductEntity product);
	void deleteProduct(int id);
}
