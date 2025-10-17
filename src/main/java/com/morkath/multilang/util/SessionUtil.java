package com.morkath.multilang.util;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	private static SessionUtil instance = null;

	public static SessionUtil getInstance() {
		if (instance == null) {
			instance = new SessionUtil();
		}
		return instance;
	}
	
	public void set(HttpServletRequest request, String key, Object value) {
		request.getSession().setAttribute(key, value);
	}
	
	public Object get(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	public void remove(HttpServletRequest request, String key) {
		request.getSession().removeAttribute(key);
	}
}
