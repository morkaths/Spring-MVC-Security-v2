package com.morkath.multilang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.morkath.multilang.dto.LanguageDTO;
import com.morkath.multilang.entity.LanguageEntity;
import com.morkath.multilang.repository.LanguageRepository;
import com.morkath.multilang.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public List<LanguageEntity> getAllLanguages() {
		return languageRepository.findAll();
	}

	@Override
	public LanguageEntity getLanguageById(String languageID) {
		return languageRepository.findById(languageID).orElse(null);
	}

	@Override
	public LanguageEntity createLanguage(LanguageDTO languageDTO) {
		return languageRepository.save(new LanguageEntity(languageDTO.getLanguageID(), languageDTO.getLanguage()));
	}

	@Override
	public LanguageEntity updateLanguage(LanguageDTO languageDTO) {
		if (languageRepository.existsById(languageDTO.getLanguageID())) {
			return languageRepository.save(new LanguageEntity(languageDTO.getLanguageID(), languageDTO.getLanguage()));
		}
		return null;
	}

	@Override
	public void deleteLanguage(String languageID) {
		languageRepository.deleteById(languageID);
	}

}
