package com.iisi.web.filequery;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.FileQueryDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.fileQuery.FileQueryService;

@Controller
@SessionScoped
public class FileQueryController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FileQueryDTO dto;
	
	@Autowired
	private FileQueryService fileQueryService;
	
	@PostConstruct
	public void init(){
		dto = new FileQueryDTO();
	}
	
	public void doQuery(){
		try{			
			this.verifyData();
			dto.setFiles(fileQueryService.getFileList(dto));
		}catch(FileSysException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			
		}
	}
	
	private void verifyData(){
		FacesContext context = FacesContext.getCurrentInstance();
		//類型
		if(null == dto.getType() || dto.getType().length() == 0){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_TYPE));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_TYPE);
		}
		//起始日
		if(null == dto.getStartDate() || dto.getStartDate().toString().length() == 0){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_START_DATE));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_START_DATE);
		}
		//迄止日
		if(null == dto.getEndDate() || dto.getEndDate().toString().length() == 0){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_END_DATE));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_END_DATE);
		}
	}

	public FileQueryDTO getDto() {
		return dto;
	}

	public void setDto(FileQueryDTO dto) {
		this.dto = dto;
	}
}
