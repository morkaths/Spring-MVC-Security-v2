package com.morkath.multilang.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LangFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String lang = req.getParameter("lang");
        HttpSession session = req.getSession();
        if (lang != null && !lang.isEmpty()) {
            session.setAttribute("lang", lang);
        } else if (session.getAttribute("lang") == null) {
            session.setAttribute("lang", "vi");
        }
        chain.doFilter(request, response);
    }
}
