package com.morkath.multilang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.morkath.multilang.core.BaseController;

@Controller
@RequestMapping({"/", "/home"})
public class HomeController extends BaseController {
	
	@GetMapping
    public String index(Model model) {
        preparePage(model, "pages/home/index", "Home");
        return "layouts/vertical";
    }
}
