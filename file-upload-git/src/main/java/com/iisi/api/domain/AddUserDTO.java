package com.iisi.api.domain;

import java.io.Serializable;

public class AddUserDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String officeData;
	
	private String officeId;
	
	private String officeName;
	
	private String userId;
	
	private String userName;
	
	private String roleId;

	public String getOfficeData() {
		return officeData;
	}

	public void setOfficeData(String officeData) {
		this.officeData = officeData;
	}
	
	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
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

	public void splitOfficeData(String data){
		if(null != data && data.length() > 0){
			this.setOfficeId(data.substring(0, data.indexOf(":")));
			this.setOfficeName(data.substring(data.indexOf(":")+1));
		}else{
			this.setOfficeId("");
			this.setOfficeName("");
		}
	}
}
