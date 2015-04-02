package com.iisi.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@IdClass(OperationLogPK.class)
@Entity
@Table(name="operationlog")
public class OperationLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 操作日期
	 */
	private String logDate;
	
	/**
	 * 操作時間
	 */
	private String logTime;
	
	/**
	 * 單位代號
	 */
	private String officeId;
	
	/**
	 * 操作內容
	 */
	private String operationContent;
	
	/**
	 * 作業名稱
	 */
	private String type;
	
	/**
	 * 使用者帳號
	 */
	private String userId;
	
	/**
	 * 使用者姓名
	 */
	private String userName;

	@Id
	@Column(name="logdate", unique=false, nullable=false, length=7)
	public String getLogDate() {
		return logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	@Id
	@Column(name="logtime", unique=false, nullable=false, length=6)
	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	@Id
	@Column(name="officeid", unique=false, nullable=false, length=3)
	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	@Id
	@Column(name="userid", unique=false, nullable=false, length=10)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name="operationcontent", unique=false, nullable=false, length=530)
	public String getOperationContent() {
		return operationContent;
	}

	public void setOperationContent(String operationContent) {
		this.operationContent = operationContent;
	}

	@Column(name="type", unique=false, nullable=false, length=2)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="username", unique=false, nullable=false, length=15)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("logDate = ").append(this.logDate).append(", ");
		sb.append("logTime = ").append(this.logTime).append(", ");
		sb.append("officeId = ").append(this.officeId).append(", ");
		sb.append("operationContent = ").append(this.operationContent).append(", ");
		sb.append("type = ").append(this.type).append(", ");
		sb.append("userId = ").append(this.userId).append(", ");
		sb.append("userName = ").append(this.userName).append(", ");
		
		return sb.toString();
	}
}
