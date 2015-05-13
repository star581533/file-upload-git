package com.iisi.core.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.iisi.api.model.ExecutantType;
import com.iisi.api.model.User;
import com.iisi.api.model.UserType;

public class UserUtil {
	private static Logger LOGGER = LoggerFactory.getLogger(UserUtil.class);
	
	public static UserType getUser(){
		ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		User user = (User)attr.getRequest().getAttribute("user");
		if(null != user){
			UserType userType = new UserType();
			userType.setOfficeId(user.getOfficeId());
			userType.setRoleId(user.getRoleId());
			userType.setState(user.getState());
			userType.setUserId(user.getUserId());
			userType.setUserName(user.getUserName());
			return userType;
		}
		throw new IllegalStateException("UserType object is not available in context.");
	}
	
	public static UserType getUser(UserType userType){
		if(null == userType){
			return getUser();
		}
		return userType;
	}
	
	public static String userId(){
		try{
			return getUser(null).getUserId();
		}catch(Exception e){}
		return "";
	}
	
	public static String officeId(){
		try{
			return getUser(null).getOfficeId();
		}catch(Exception e){}
		return "";
	}	
	
	public static ExecutantType getExecutant(){
		HttpSession session = SessionUtil.getSession();	
		System.out.println("session = " + session);
		ExecutantType executant = getExecutantByUser(session, null);		
		return executant;
	}
	
	public static ExecutantType getExecutantByUser(HttpSession session, UserType userType){
		ExecutantType executant = new ExecutantType();
		setupUser(executant, userType);
		executant.setIp(getUserIPAddress());
		return executant;
	}
	
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
	
	private static void setupUser(ExecutantType executant, UserType user){
		UserType userType = getUser(user);
		executant.setUser(userType);
	}
}
