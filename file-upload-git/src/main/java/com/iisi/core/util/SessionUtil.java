package com.iisi.core.util;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public final class SessionUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionUtil.class);
	
	public static HttpSession getSession(){
		try{
			ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
			return attr.getRequest().getSession(true);
		}catch(IllegalStateException e){
			LOGGER.warn("can't get session : {}", e.getMessage());
		}
		return null;
	}
	
}
