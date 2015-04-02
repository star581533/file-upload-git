package com.iisi.api.domain;

import java.io.Serializable;
import java.util.List;

import com.iisi.api.model.FileData;

public class FileDeleteDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;
	
	private String sercet;
	
	private String startDate;
	
	private String endDate;
	
	private String classNum;
	
	private String disPatchNum;
	
	private String subject;
	
	private String government;
	
	private List<FileData> files;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSercet() {
		return sercet;
	}

	public void setSercet(String sercet) {
		this.sercet = sercet;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public List<FileData> getFiles() {
		return files;
	}

	public void setFiles(List<FileData> files) {
		this.files = files;
	}
}
