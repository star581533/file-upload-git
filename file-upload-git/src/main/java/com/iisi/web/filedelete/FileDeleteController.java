package com.iisi.web.filedelete;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.iisi.api.domain.FileDeleteDTO;


@ManagedBean
@ViewScoped
public class FileDeleteController implements Serializable {

	private FileDeleteDTO dto;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@PostConstruct
	public void init(){
		dto = new FileDeleteDTO();
	}
	
	public void doQuery(){
		
	}
	
//	private void verifyData(){
//		
//	}

	public FileDeleteDTO getDto() {
		return dto;
	}

	public void setDto(FileDeleteDTO dto) {
		this.dto = dto;
	}	
}
