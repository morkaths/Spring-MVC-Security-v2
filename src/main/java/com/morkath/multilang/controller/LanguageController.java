package com.morkath.multilang.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.morkath.multilang.core.BaseController;
import com.morkath.multilang.dto.LanguageDTO;
import com.morkath.multilang.service.LanguageService;

@Controller
@RequestMapping("/admin/languages")
public class LanguageController extends BaseController {
	@Autowired
	private LanguageService languageService;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("languages", languageService.getAllLanguages());
		model.addAttribute("languageForm", new LanguageDTO());
		preparePage(model, "pages/admin/language", "Language Management");
		return "layouts/vertical";
	}
	
	@GetMapping("/add")
	public String addLanguage(
		@Valid @ModelAttribute("languageForm") LanguageDTO languageForm,
		BindingResult bindingResult,
		Model model
	) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("languages", languageService.getAllLanguages());
      model.addAttribute("showModal", true);
			preparePage(model, "pages/admin/language", "Language Management");
			return "layouts/vertical";
		}
		languageService.createLanguage(languageForm);
		return "redirect:/admin/language";
	}
	
	
	
	
}
