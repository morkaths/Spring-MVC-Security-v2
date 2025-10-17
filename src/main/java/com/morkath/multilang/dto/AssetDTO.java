package com.morkath.multilang.dto;

import java.util.List;

public class AssetDTO {
	private String title;
	private List<String> stylesheets;
	private List<String> scripts;
	
	public AssetDTO() {
		super();
	}
	
	public AssetDTO(String title) {
		super();
		this.title = title;
	}

	public AssetDTO(String title, List<String> stylesheets, List<String> scripts) {
		super();
		this.title = title;
		this.stylesheets = stylesheets;
		this.scripts = scripts;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getStylesheets() {
		return stylesheets;
	}

	public void setStylesheets(List<String> stylesheets) {
		this.stylesheets = stylesheets;
	}

	public List<String> getScripts() {
		return scripts;
	}

	public void setScripts(List<String> scripts) {
		this.scripts = scripts;
	}
	
	public void addStylesheets(String... stylesheets) {
		for (String stylesheet : stylesheets) this.stylesheets.add(stylesheet);
	}
	
	public void addScripts(String... scripts) {
		for (String script : scripts) this.scripts.add(script);
	}
}
