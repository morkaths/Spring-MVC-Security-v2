package com.morkath.multilang.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LangInterceptor implements HandlerInterceptor {
  @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        String lang = request.getParameter("lang");
        if (lang == null) {
            lang = (String) request.getSession().getAttribute("lang");
            if (lang == null) lang = "vi";
        } else {
            request.getSession().setAttribute("lang", lang);
        }
        if (modelAndView != null) {
            modelAndView.addObject("lang", lang);
        }
    }
}
