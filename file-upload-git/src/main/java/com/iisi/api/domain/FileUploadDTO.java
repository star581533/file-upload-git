package com.iisi.api.domain;

import java.io.Serializable;

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
	
	private String disPatchDate;
		
	private String classNum;
	
	private String disPatchNum;
	
	private String subject;
	
	private String government;
	
	private UploadedFile uploadFile;

	private User user;
	
	private FileData fileData;
	
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

	public String getDisPatchDate() {
		return disPatchDate;
	}

	public void setDisPatchDate(String disPatchDate) {
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

	public FileData getFileData() {
		return fileData;
	}

	public void setFileData(FileData fileData) {
		this.fileData = fileData;
	}	
}
