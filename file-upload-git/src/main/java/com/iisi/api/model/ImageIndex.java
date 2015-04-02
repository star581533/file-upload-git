package com.iisi.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="imageindex")
public class ImageIndex {
	
	private String imageId;
	
	private String imageName;

	@Id
	@Column(name="imageid", unique=true, nullable=false, length=16)
	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	@Column(name="imagename", unique=false, nullable=false)
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("imageId = ").append(this.imageId).append(", ");
		sb.append("imageName = ").append(this.imageName).append(", ");
		
		return sb.toString();
	}
	
}
