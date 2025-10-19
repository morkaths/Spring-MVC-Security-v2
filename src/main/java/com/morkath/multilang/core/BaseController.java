package com.morkath.multilang.core;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.morkath.multilang.dto.AssetDTO;

public abstract class BaseController {
	
	@ModelAttribute("assets")
    public AssetDTO defaultAssets() {
        return new AssetDTO("Default Title");
    }
	
	/**
	 * Prepare the page with content and title
	 * @param model - The model to add attributes to
	 * @param page - The content page to be displayed
	 * @param title - The title of the page
	 */
	protected void preparePage(Model model, String page, String title) {
        model.addAttribute("content", page);
        model.addAttribute("assets", new AssetDTO(title));
    }
	
	/**
	 * Prepare the page with content and assets
	 * @param model - The model to add attributes to
	 * @param page - The content page to be displayed
	 * @param assets - The AssetDTO containing page assets
	 */
	protected void preparePage(Model model, String page, AssetDTO assets) {
		model.addAttribute("content", page);
		model.addAttribute("assets", assets);
	}
	
}
