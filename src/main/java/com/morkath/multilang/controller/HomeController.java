package com.morkath.multilang.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.morkath.multilang.core.BaseController;

@Controller
public class HomeController extends BaseController {
	
	@GetMapping("/")
	 public String index(HttpServletRequest request, Model model) {
		preparePage(model, "pages/home/index", "User Management");
        return "layouts/vertical";
    }
}
