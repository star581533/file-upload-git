package com.iisi.web.listener;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
//		ServletContext application = session.getServletContext();
		
		String userId = (String) session.getAttribute("userId");
		System.out.println("userId = " + userId);
		
		System.out.println("session.getAttributeNames() = " + session.getAttributeNames());
		
		Enumeration e = session.getAttributeNames();
		while(e.hasMoreElements()){
			String name = (String)e.nextElement();
			System.out.println(name + "=" + session.getAttribute(name));
		}
	}

}
