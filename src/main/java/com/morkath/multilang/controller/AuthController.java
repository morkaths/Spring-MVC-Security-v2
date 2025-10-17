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
import com.morkath.multilang.dto.LoginForm;
import com.morkath.multilang.model.User;
import com.morkath.multilang.util.SessionUtil;

@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {
	
//	private final AuthService authService;
//	
//	@Autowired
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
	
	@GetMapping("/login")
    public String login(Model model) {
        preparePage(model, "pages/auth/login", "Login");
        model.addAttribute("loginForm", new LoginForm());
        return "layouts/auth";
    }
	
	@GetMapping("/register")
	public String register(Model model) {
		preparePage(model, "pages/auth/register", "Register");
		return "layouts/auth";
	}
	
//	@PostMapping("/login")
//	public String doLogin(
//		@Valid @ModelAttribute("loginForm") LoginForm loginForm,
//		BindingResult bindingResult,
//	    Model model,
//	    HttpServletRequest request
//	) {
//		if (bindingResult.hasErrors()) {
//	        preparePage(model, "pages/auth/login", "Login");
//	        return "layouts/auth";
//	    }
//		User user = authService.login(loginForm.getUsername(), loginForm.getPassword());
//		if (user == null) {
//			bindingResult.rejectValue("username", "error.loginForm", "Tên đăng nhập hoặc mật khẩu không đúng");
//			preparePage(model, "pages/auth/login", "Login");
//	        return "layouts/auth";
//		}
//		
//		SessionUtil.getInstance().set(request, "currentUser", user);
//		return "redirect:/home";
//	}
	
}
