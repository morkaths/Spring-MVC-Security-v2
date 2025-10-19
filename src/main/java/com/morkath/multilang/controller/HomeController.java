package com.morkath.multilang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.morkath.multilang.core.BaseController;
import com.morkath.multilang.service.ProductService;

@Controller
public class HomeController extends BaseController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	 public String index(HttpServletRequest request, Model model) {
		String lang = request.getParameter("lang");
		if (lang == null || lang.isEmpty()) {
        Object sessionLang = request.getSession().getAttribute("lang");
        lang = sessionLang != null ? sessionLang.toString() : "vi";
    }
		model.addAttribute("products", productService.getAllProducts(lang));
		preparePage(model, "pages/home/index", "User Management");
        return "layouts/vertical";
    }
}
