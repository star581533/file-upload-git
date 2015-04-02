package com.iisi.api.domain;

import java.io.Serializable;
import java.util.List;

import com.iisi.api.model.User;

public class QueryUserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String officeData;
	
	private String state;

	private String officeId;
	
	private String officeName;
	
	private List<User> users;
	
	private User user;
		
	public String getOfficeData() {
		return officeData;
	}

	public void setOfficeData(String officeData) {
		this.officeData = officeData;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
		
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
