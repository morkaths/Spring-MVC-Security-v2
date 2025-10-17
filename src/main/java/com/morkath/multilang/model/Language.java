package com.morkath.multilang.model;

public class Language {
	private String languageID;
	private String language;
	
	public Language() {
		super();
	}

	public Language(String languageID, String language) {
		super();
		this.languageID = languageID;
		this.language = language;
	}

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

	@Override
	public String toString() {
		return "Language [languageID=" + languageID + ", language=" + language + "]";
	}
	
}
