// package com.morkath.multilang.security;

// import com.morkath.multilang.util.JwtUtil;
// import com.morkath.multilang.util.SessionUtil;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.web.filter.OncePerRequestFilter;

// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;

// public class JwtAuthenticationFilter extends OncePerRequestFilter {
// 	@Override
// 	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
// 			throws ServletException, IOException {
// 		String jwtToken = (String) SessionUtil.getInstance().get(request, "jwtToken");
// 		if (jwtToken != null) {
// 			String username = JwtUtil.validateToken(jwtToken);
// 			if (username != null) {
// 				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
// 						null, null);
// 				SecurityContextHolder.getContext().setAuthentication(authentication);
// 			}
// 		}
// 		filterChain.doFilter(request, response);
// 	}
// }
