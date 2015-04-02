package com.iisi.api.model;

import java.io.Serializable;

public class OperationLogPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String logDate;
	
	private String logTime;
	
	private String officeId;
	
	private String userId;

	public OperationLogPK() {}
	
	
	public String getLogDate() {
		return logDate;
	}
	
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
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
		
		if(!(obj instanceof OperationLogPK)){
			return false;
		}
		
		if(obj == null){
			return false;
		}
		
		OperationLogPK pk = (OperationLogPK) obj;
				
		boolean rtn = 
				pk.logDate.equals(logDate) && pk.logTime.equals(logTime) && pk.officeId.equals(officeId) && pk.userId.equals(userId);
		
		return rtn;
	}
}
