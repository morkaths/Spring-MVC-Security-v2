package com.morkath.multilang.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.morkath.multilang.core.BaseController;
import com.morkath.multilang.dto.LoginForm;
import com.morkath.multilang.dto.RegisterForm;
import com.morkath.multilang.service.AuthService;

@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {

	@Autowired
	private AuthService authService;

	@GetMapping("/login")
	public String login(Model model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "registered", required = false) String registered) {
		preparePage(model, "pages/auth/login", "Login");
		model.addAttribute("loginForm", new LoginForm());
		if (registered != null) {
			model.addAttribute("registerSuccess", "Đăng ký thành công! Vui lòng đăng nhập.");
		}
		if (error != null) {
			model.addAttribute("loginError", "Tên đăng nhập hoặc mật khẩu không đúng!");
		}
		return "layouts/auth";
	}

	@GetMapping("/register")
	public String register(Model model) {
		preparePage(model, "pages/auth/register", "Register");
		model.addAttribute("registerForm", new RegisterForm());
		return "layouts/auth";
	}

	// @PostMapping("/login")
	// public String doLogin(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult,
	// 		Model model) {
	// 	if (bindingResult.hasErrors()) {
	// 		preparePage(model, "pages/auth/login", "Login");
	// 		return "layouts/auth";
	// 	}
	// 	if (authService.login(loginForm.getUsername(), loginForm.getPassword()) == null) {
	// 		bindingResult.rejectValue("username", "error.loginForm", "Tên đăng nhập hoặc mật khẩu không đúng");
	// 		preparePage(model, "pages/auth/login", "Login");
	// 		return "layouts/auth";
	// 	}
	// 	return "redirect:/admin/dashboard";
	// }

	@PostMapping("/register")
	public String doRegister(@Valid @ModelAttribute("registerForm") RegisterForm registerForm,
			BindingResult bindingResult, Model model) {
		if (!registerForm.getPassword().equals(registerForm.getConfirmPassword())) {
			bindingResult.rejectValue("confirmPassword", "error.registerForm", "Mật khẩu xác nhận không khớp");
		}
		if (bindingResult.hasErrors()) {
			preparePage(model, "pages/auth/register", "Register");
			return "layouts/auth";
		}

		boolean success = authService.register(registerForm.getUsername(), registerForm.getPassword(),
				registerForm.getEmail());
		if (!success) {
			bindingResult.rejectValue("email", "error.registerForm", "Đăng ký thất bại, vui lòng thử lại");
			preparePage(model, "pages/auth/register", "Register");
			return "layouts/auth";
		}
		return "redirect:/auth/login?registered";
	}

	@GetMapping("/logout")
	public String logout() {
		return "redirect:/auth/login";
	}
}
