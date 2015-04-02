package com.iisi.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="office")
public class Office {

	/**
	 * 單位代號
	 */
	private String officeId;
	
	/**
	 * 單位名稱
	 */
	private String officeName;

	public Office(){}
	
	public Office(String officeId, String officeName){
		this.officeId = officeId;
		this.officeName = officeName;
	}
	
	@Id
	@Column(name="officeid", unique=true, nullable=false, length=3)
	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	@Column(name="officename", unique=false, nullable=false, length=10)
	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("officeId = ").append(this.officeId).append(", ");
		sb.append("officeName = ").append(this.officeName);
		
		return super.toString();
	}
}
