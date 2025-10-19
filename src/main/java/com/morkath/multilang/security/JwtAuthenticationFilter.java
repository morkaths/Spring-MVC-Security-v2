package com.morkath.multilang.security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.morkath.multilang.util.JwtUtil;
import com.morkath.multilang.util.SessionUtil;

@WebFilter(urlPatterns = {"/dashboard"})
public class JwtAuthenticationFilter implements Filter {
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        System.out.println("Filter checking: " + httpRequest.getRequestURI());
        
        String jwtToken = (String) SessionUtil.getInstance().get(httpRequest, "jwtToken");
        
        System.out.println("Token exists: " + (jwtToken != null));
        
        if (jwtToken == null || JwtUtil.validateToken(jwtToken) == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/auth/login");
            return;
        }
        System.out.println("Authentication successful, proceeding");
        chain.doFilter(request, response);
    }
}
