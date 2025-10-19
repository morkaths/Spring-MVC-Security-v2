package com.morkath.multilang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.morkath.multilang.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
	@Query("SELECT p FROM ProductEntity p " +
       "LEFT JOIN FETCH p.translations t " +
       "LEFT JOIN FETCH p.productCategory pc " +
       "LEFT JOIN FETCH pc.translations pct " +
       "WHERE t.languageID = :lang AND pct.languageID = :lang")
	List<ProductEntity> findAllWithTranslation(@Param("lang") String lang);
}
