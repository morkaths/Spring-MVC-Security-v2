package com.morkath.multilang.service;

import java.util.List;

import com.morkath.multilang.dto.LanguageDTO;
import com.morkath.multilang.entity.LanguageEntity;

public interface LanguageService {
	List<LanguageEntity> getAllLanguages();
	LanguageEntity getLanguageById(String languageID);
	LanguageEntity createLanguage(LanguageDTO languageDTO);
	LanguageEntity updateLanguage(LanguageDTO languageDTO);
	void deleteLanguage(String languageID);
}
