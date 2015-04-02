//http://www.journaldev.com/3229/primefaces-fileupload-component-example-tutorial
package com.iisi.web.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Controller;

import com.iisi.api.domain.FileUploadDTO;


@Controller
@SessionScoped
public class FileUploadController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FileUploadDTO dto;
	
	private UploadedFile uploadedFile;
	
	@PostConstruct
	public void init(){
		dto = new FileUploadDTO();
	}
	
	public void uploadData(){
		
	}
	
	private void verifyData(){
			
	}
	
	private boolean verifyString(String str){
		boolean rtnBool = false;
		
		if(null == str || str.length() == 0){
			rtnBool = true;
		}		
		return rtnBool;
	}

	public void doSubmit(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		
		String directory = externalContext.getInitParameter("uploadDirectory");
		
		File masterDir = new File(directory);
		
		if(!masterDir.exists()){
			masterDir.mkdir();
		}
	}
	
	public FileUploadDTO getDto() {
		return dto;
	}

	public void setDto(FileUploadDTO dto) {
		this.dto = dto;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
}
