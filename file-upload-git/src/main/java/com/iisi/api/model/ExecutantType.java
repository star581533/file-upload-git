package com.iisi.api.model;

import java.io.Serializable;

public class ExecutantType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 使用者資訊
	 */
	private UserType user;
	
	/**
	 * IP位址
	 */
	private String ip;

	public UserType getUser() {
		return user;
	}

	public void setUser(UserType user) {
		this.user = user;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public String toString() {
		return "ExecutantType [ user=" + this.user + ", ip=" + this.ip + "] ";
	}
}
