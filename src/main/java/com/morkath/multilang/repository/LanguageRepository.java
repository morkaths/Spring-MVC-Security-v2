package com.morkath.multilang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.morkath.multilang.entity.LanguageEntity;

public interface LanguageRepository extends JpaRepository<LanguageEntity, String> {}