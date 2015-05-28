package com.iisi.api.domain;

import java.io.Serializable;
import java.util.Date;

import org.primefaces.model.UploadedFile;

import com.iisi.api.model.FileData;
import com.iisi.api.model.User;

public class FileUploadDTO implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;
	
	private String secret;
	
	private Date disPatchDate;
		
	private String classNum;
	
	private String disPatchNum;
	
	private String subject;
	
	private String government;
	
	private UploadedFile uploadFile;

	private User user;
	
	private String filePath;
	
	private String imageId;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public Date getDisPatchDate() {
		return disPatchDate;
	}

	public void setDisPatchDate(Date disPatchDate) {
		this.disPatchDate = disPatchDate;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public String getDisPatchNum() {
		return disPatchNum;
	}

	public void setDisPatchNum(String disPatchNum) {
		this.disPatchNum = disPatchNum;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGovernment() {
		return government;
	}

	public void setGovernment(String government) {
		this.government = government;
	}

	public UploadedFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(UploadedFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
}
