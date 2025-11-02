package com.morkath.multilang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.morkath.multilang.core.BaseController;
import com.morkath.multilang.entity.AuthUserEntity;
import com.morkath.multilang.service.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController extends BaseController {

  @Autowired
	private UserService userService;

  @GetMapping
  public String profile(Model model) {
    AuthUserEntity currentUser = userService.getCurrentUser();
    model.addAttribute("user", currentUser);
    preparePage(model, "pages/user/profile", "User Profile");
    return "layouts/vertical";
  }


}
