package com.yonyou.hotusm.common.web.session;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpSessionFilter implements Filter{

	public void destroy() {
		
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain filterChain) throws IOException, ServletException {
		
		//HttpServletRequest request=(HttpServletRequest) req;
		//HttpServletResponse response=(HttpServletResponse) resp;
		filterChain.doFilter(req, resp);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
