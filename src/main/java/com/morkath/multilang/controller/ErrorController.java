package com.morkath.multilang.controller;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.security.access.AccessDeniedException;

import com.morkath.multilang.dto.AssetDTO;

@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException ex, Model model) {
        model.addAttribute("content", "/WEB-INF/views/pages/error/404.jsp");
        model.addAttribute("assets", new AssetDTO("Not Found", Collections.emptyList(), Collections.emptyList()));
        return "layouts/error";
    }

	@ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handle403(Exception ex, Model model) {
        model.addAttribute("content", "/WEB-INF/views/pages/error/403.jsp");
        model.addAttribute("assets", new AssetDTO("Access Forbidden", Collections.emptyList(), Collections.emptyList()));
        return "layouts/error";
    }

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handle500(Exception ex, Model model) {
        model.addAttribute("content", "/WEB-INF/views/pages/error/500.jsp");
        model.addAttribute("assets", new AssetDTO("System Error", Collections.emptyList(), Collections.emptyList()));
        return "layouts/error";
    }
	
}
