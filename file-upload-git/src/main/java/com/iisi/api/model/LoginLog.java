package com.iisi.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@IdClass(LoginLogPK.class)
@Entity
@Table(name="loginlog")
public class LoginLog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 工作註記
	 */
	private String inOutMark;
	
	/**
	 * 作業日期
	 */
	private String loginDate;
	
	/**
	 * 作業時間
	 */
	private String loginTime;
	
	/**
	 * 單位代號
	 */
	private String officeId;
	
	/**
	 * 權限代號
	 */
	private String roleId;
	
	/**
	 * 使用者帳號
	 */
	private String userId;
	
	/**
	 * 使用者姓名
	 */
	private String userName;

	@Id
	@Column(name="logindate", unique=false, nullable=false, length=7)
	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	@Id
	@Column(name="logintime", unique=false, nullable=false, length=6)
	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
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
	
	@Column(name="inoutmark", unique=false, nullable=false, length=1)
	public String getInOutMark() {
		return inOutMark;
	}

	public void setInOutMark(String inOutMark) {
		this.inOutMark = inOutMark;
	}
	
	@Column(name="roleid", unique=false, nullable=false, length=1)
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name="username", unique=false, nullable=false, length=5)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("inOutMark = ").append(this.inOutMark).append(", ");
		sb.append("loginDate = ").append(this.loginDate).append(", ");
		sb.append("loginTime = ").append(this.loginTime).append(", ");
		sb.append("officeId = ").append(this.officeId).append(", ");
		sb.append("roleId = ").append(this.roleId).append(", ");
		sb.append("userId = ").append(this.userId).append(", ");
		sb.append("userName = ").append(this.userName);
		
		return sb.toString();
	}	
}
