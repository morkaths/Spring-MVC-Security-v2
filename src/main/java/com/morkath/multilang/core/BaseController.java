package com.morkath.multilang.core;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.morkath.multilang.dto.AssetDTO;

public abstract class BaseController {
	
	@ModelAttribute("assets")
    public AssetDTO defaultAssets() {
        return new AssetDTO("Default Title");
    }
	
	protected void preparePage(Model model, String page, String title) {
        model.addAttribute("content", page);
        model.addAttribute("assets", new AssetDTO(title));
    }
	
	protected void preparePage(Model model, String page, AssetDTO assets) {
		model.addAttribute("content", page);
		model.addAttribute("assets", assets);
	}
	
}
