package com.iisi.api.domain;

import java.io.Serializable;

public class UserDataDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 科別
	 */
	private String officeId;
	
	/**
	 * 使用者帳號
	 */
	private String userId;
	
	/**
	 * 使用者名稱
	 */
	private String userName;
	
	/**
	 * 使用者權限
	 */
	private String roleId;
	
	/**
	 * 狀態
	 */
	private String state;

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
