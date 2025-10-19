package com.morkath.multilang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.morkath.multilang.core.BaseController;
import com.morkath.multilang.dto.UserForm;
import com.morkath.multilang.entity.AuthUserEntity;
import com.morkath.multilang.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String index(HttpServletRequest request, Model model) {
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("userForm", new UserForm());
		preparePage(model, "pages/user/index", "User Management");
		return "layouts/vertical";
	}

	@PostMapping("/add")
	public String addUser(
		@Valid @ModelAttribute("userForm") UserForm userForm, 
		BindingResult bindingResult,
		Model model
	) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("users", userService.getAllUsers());
			preparePage(model, "pages/user/index", "User Management");
			return "layouts/vertical"; // Return to form with errors
		}
		AuthUserEntity user = userService.createUser(userForm);
		if (user == null) {
			bindingResult.rejectValue("username", "error.userForm", "Không thể tạo người dùng");
			model.addAttribute("users", userService.getAllUsers());
			preparePage(model, "pages/user/index", "User Management");
			return "layouts/vertical";
		}
		return "redirect:/admin/user";
	}
}
