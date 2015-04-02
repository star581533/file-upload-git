package com.iisi.api.domain;

import java.io.Serializable;

import com.iisi.api.model.User;

public class LoginDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId;
	
	private String password;

	private boolean checkLogin;
	
	private User user;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isCheckLogin() {
		return checkLogin;
	}

	public void setCheckLogin(boolean checkLogin) {
		this.checkLogin = checkLogin;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
