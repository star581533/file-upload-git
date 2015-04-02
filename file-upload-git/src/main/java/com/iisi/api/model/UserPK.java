//http://laodaobazi.iteye.com/blog/903236
package com.iisi.api.model;

import java.io.Serializable;

public class UserPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String officeId;
	
	private String userId;

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
	public boolean equals(Object o) {
		if(o instanceof UserPK){
			UserPK key = (UserPK)o;
			if(this.officeId.equals(key.getOfficeId()) && this.userId.equals(key.getUserId())){
				return true;
			}
		}
		return false;
	}
}
