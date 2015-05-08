package com.iisi.core.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class UserUtil {
	private static Logger LOGGER = LoggerFactory.getLogger(UserUtil.class);
	
	
	public static String getUserIPAddress(){
		HttpServletRequest httpServletRequest = null;
		try{
			httpServletRequest = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		}catch(Exception e){
			LOGGER.warn("get user ip address:{}", e.getMessage());
			LOGGER.error(e.getMessage(), e);
			return "";
		}
		
		String ip = httpServletRequest.getHeader("X-Forwarded-For");
		String rip = httpServletRequest.getRemoteAddr();
		if(ip != null){
			ip = ip.split("\\s*,\\s*")[0].trim();
		}
		LOGGER.trace("X-Forward-For: {}, RemoteAddr: {}", ip, rip);
		return ((ip == null ? rip : ip));
	}
}
