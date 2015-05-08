package com.iisi.api.model;

import java.io.Serializable;

public class UserType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 單位代號
	 */
	private String officeId;
	
	/**
	 * 權限代號
	 */
	private String roleId;
	
	/**
	 * 在職狀態
	 */
	private String state;
	
	/**
	 * 使用者帳號
	 */
	private String userId;
	
	/**
	 * 使用者姓名
	 */
	private String userName;

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
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
	
	@Override
	public String toString() {
		return "UserType [ userName=" + this.userName + ", userId="+ this.userId + ", officeId="+ 
					this.officeId + ", roleId=" + this.roleId + ", state=" + this.state + "] ";
	}
}
