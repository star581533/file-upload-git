package com.iisi.api.model;

import java.io.Serializable;

public class LoginLogPK implements Serializable{

	private String loginDate;
	
	private String loginTime;
	
	private String officeId;
	
	private String userId;

	public LoginLogPK() {}
	
	
	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

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
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true;
		}
		
		if(!(obj instanceof LoginLogPK)){
			return false;
		}
		
		if(obj == null){
			return false;
		}
		
		LoginLogPK pk = (LoginLogPK) obj;
				
		boolean rtn = 
				pk.loginDate.equals(loginDate) && pk.loginTime.equals(loginTime) && pk.officeId.equals(officeId) && pk.userId.equals(userId);
		
		return rtn;
	}
}
