//http://www.itzhai.com/java-web-notes-servlet-filters-in-the-filter-writing-the-introduction-and-use-of-filters.html
package com.iisi.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("SessionFilter init");		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = (HttpSession)request.getSession();
		String sessionId = (String)session.getAttribute("Session_ID");
		String uri = request.getRequestURI();
		
		System.out.println("session = " + session);
		System.out.println("SessionFilter sessionId = " + sessionId);
		System.out.println("SessionFilter uri = " + uri);
		
		if(sessionId == null && !uri.equals("/GitJSF/login.xhtml")){
			session.invalidate();
			response.sendRedirect("/GitJSF/login.xhtml");
		}else{
			HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(response);
			chain.doFilter(request, wrappedResponse);
		}		
	}
}
