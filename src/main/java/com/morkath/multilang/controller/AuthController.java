package com.morkath.multilang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.morkath.multilang.core.BaseController;
import com.morkath.multilang.dto.LoginForm;
import com.morkath.multilang.dto.RegisterForm;
import com.morkath.multilang.service.AuthService;
import com.morkath.multilang.util.SessionUtil;

@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {

	@Autowired
	private AuthService authService;

	@GetMapping("/login")
	public String login(Model model) {
		preparePage(model, "pages/auth/login", "Login");
		model.addAttribute("loginForm", new LoginForm());
		return "layouts/auth";
	}

	@GetMapping("/register")
	public String register(Model model) {
		preparePage(model, "pages/auth/register", "Register");
		model.addAttribute("registerForm", new RegisterForm());
		return "layouts/auth";
	}

	@PostMapping("/login")
	public String doLogin(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult,
			Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			preparePage(model, "pages/auth/login", "Login");
			return "layouts/auth";
		}
		String jwtToken = authService.login(loginForm.getUsername(), loginForm.getPassword());
		System.out.println("JWT Token generated: " + (jwtToken != null ? "Success" : "Failed"));
		if (jwtToken == null) {
			bindingResult.rejectValue("username", "error.loginForm", "Tên đăng nhập hoặc mật khẩu không đúng");
			preparePage(model, "pages/auth/login", "Login");
			return "layouts/auth";
		}

		SessionUtil.getInstance().set(request, "jwtToken", jwtToken);
		return "redirect:/admin/dashboard";
	}

	@PostMapping("/register")
	public String doRegister(@Valid @ModelAttribute("registerForm") RegisterForm registerForm,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (!registerForm.getPassword().equals(registerForm.getConfirmPassword())) {
			bindingResult.rejectValue("confirmPassword", "error.registerForm", "Mật khẩu xác nhận không khớp");
		}
		if (bindingResult.hasErrors()) {
			preparePage(model, "pages/auth/register", "Register");
			return "layouts/auth";
		}
		
		String jwtToken = authService.register(
				registerForm.getUsername(), 
				registerForm.getPassword(),
				registerForm.getEmail());
		System.out.println("JWT Token generated: " + jwtToken);
		if (jwtToken == null) {
			bindingResult.rejectValue("email", "error.registerForm", "Đăng ký thất bại, vui lòng thử lại");
			preparePage(model, "pages/auth/register", "Register");
	        return "layouts/auth";
		}
		SessionUtil.getInstance().set(request, "jwtToken", jwtToken);
		return "redirect:/auth/login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SessionUtil.getInstance().remove(request, "jwtToken");
		SessionUtil.getInstance().remove(request, "username");
		return "redirect:/auth/login";
	}
}
