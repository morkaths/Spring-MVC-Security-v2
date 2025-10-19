package com.morkath.multilang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.morkath.multilang.core.BaseController;

@Controller
@RequestMapping("/admin")
public class DashboardController extends BaseController {
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		preparePage(model, "pages/admin/dashboard", "Dashboard");
		return "layouts/vertical";
	}
}
