package com.morkath.multilang.dto;

import javax.validation.constraints.NotBlank;

public class LanguageDTO {
	
	@NotBlank(message = "Language ID không được để trống")
	private String languageID;
	
	@NotBlank(message = "Language không được để trống")
	private String language;
	
	public String getLanguageID() {
		return languageID;
	}
	
	public void setLanguageID(String languageID) {
		this.languageID = languageID;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
}
