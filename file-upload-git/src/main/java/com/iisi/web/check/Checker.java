package com.iisi.web.check;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.model.User;

public class Checker {
	
	public static String checkAndConfirmUser(){
		System.out.println("checkUser(getUser()) = " + checkUser(getUser()));
		return checkUser(getUser());
	}
	
	/**
	 * 取得畫面中User資料
	 * @return
	 */
	public static User getUser(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();		
		User user = (User)request.getSession().getAttribute("user");
		System.out.println("check user = " + user);
		return user;
	}
		
	public static String checkUser(User user){		
		if(user == null){
			return "login.xhtml?faces-redirect=true";
		}
		
		if(confirmUser(user)){
			return "login.xhtml?faces-redirect=true";
		}else{
			return "";
		}
	}
	
	/**
	 * 確認使用者資料是否有值
	 * @param user
	 * @return
	 */
	private static boolean confirmUser(User user){
		if(ConstantMethod.verifyColumn(user.getUserId())){
			return true;
		}
		if(ConstantMethod.verifyColumn(user.getUserName())){
			return true;
		}
		if(ConstantMethod.verifyColumn(user.getState())){
			return true;
		}
		if(ConstantMethod.verifyColumn(user.getRoleId())){
			return true;
		}
		if(ConstantMethod.verifyColumn(user.getOfficeId())){
			return true;
		}
		return false;
	}
}
