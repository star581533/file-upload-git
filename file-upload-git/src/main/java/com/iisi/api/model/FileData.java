//http://itdevelopmentblog.blogspot.tw/2014/05/java-spring-3-annotation-hibernate-4.html

package com.iisi.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="filedata")
public class FileData {
	
	/**
	 * 分類號
	 */
	private String classNum;
	
	/**
	 * 日期
	 */
	private String disPatchDate;
	
	/**
	 * 公文文號
	 */
	private String disPatchNum;
	
	/**
	 * 檔案名稱
	 */
	private String fileName;
	
	/**
	 * 機關
	 */
	private String government;
	
	/**
	 * 影像編號
	 */
	private String imageId;
	
	/**
	 * 目錄位置
	 */
	private String list;
	
	/**
	 * 單位代號
	 */
	private String officeId;
	
	/**
	 * 權限代號
	 */
	private String roleId;
	
	/**
	 * 密件
	 */
	private String secret;
	
	/**
	 * 檔案主旨
	 */
	private String subject;
	
	/**
	 * 類型
	 */
	private String type;
	
	/**
	 * 上傳日期
	 */
	private String uploadDate;
	
	/**
	 * 上傳時間
	 */
	private String uploadTime;
	
	/**
	 * 使用者帳號
	 */
	private String userId;
	
	/**
	 * 使用者姓名
	 */
	private String userName;

	@Id
	@Column(name="imageid", unique=false, nullable=false, length=16)
	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	
	@Column(name="classnum", unique=false, nullable=false, length=10)
	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	@Column(name="dispatchdate", unique=false, nullable=false, length=7)
	public String getDisPatchDate() {
		return disPatchDate;
	}

	public void setDisPatchDate(String disPatchDate) {
		this.disPatchDate = disPatchDate;
	}

	@Column(name="dispatchnum", unique=false, nullable=false, length=16)
	public String getDisPatchNum() {
		return disPatchNum;
	}

	public void setDisPatchNum(String disPatchNum) {
		this.disPatchNum = disPatchNum;
	}

	@Column(name="filename", unique=false, nullable=false, length=30)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name="government", unique=false, nullable=false, length=120)
	public String getGovernment() {
		return government;
	}

	public void setGovernment(String government) {
		this.government = government;
	}

	@Column(name="list", unique=false, nullable=false, length=24)
	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	@Column(name="officeid", unique=false, nullable=false, length=3)
	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	@Column(name="roleid", unique=false, nullable=false, length=1)
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name="secret", unique=false, nullable=false, length=1)
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Column(name="subject", unique=false, nullable=false, length= 200)
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(name="type", unique=false, nullable=false, length=1)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="uploaddate", unique=false, nullable=false, length=7)
	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Column(name="uploadtime", unique=false, nullable=false, length=6)
	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Column(name="userid", unique=false, nullable=false, length=10)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
		
		sb.append("classNum = ").append(this.classNum).append(", ");
		sb.append("disPatchDate = ").append(this.disPatchDate).append(", ");
		sb.append("disPatchNum").append(this.disPatchNum).append(", ");
		sb.append("fileName = ").append(this.fileName).append(", ");
		sb.append("government = ").append(this.government).append(", ");
		sb.append("imageId = ").append(this.imageId).append(", ");
		sb.append("list = ").append(this.list).append(", ");
		sb.append("officeId = ").append(this.officeId).append(", ");
		sb.append("roleId = ").append(this.roleId).append(", ");
		sb.append("secret = ").append(this.secret).append(", ");
		sb.append("subject = ").append(this.subject).append(", ");
		sb.append("type = ").append(this.type).append(", ");
		sb.append("uploadDate = ").append(this.uploadDate).append(", ");
		sb.append("uploadTime = ").append(this.uploadTime).append(", ");
		sb.append("userId = ").append(this.userId).append(", ");
		sb.append("userName = ").append(this.userName);
		
		return sb.toString();
	}
	
}
