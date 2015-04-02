package com.iisi.web.operationlogquery;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.OperationLogQueryDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.operationLog.OperationLogService;


@Controller
@SessionScoped
public class OperationLogQueryController{
	
	private OperationLogQueryDTO dto;
	
	@Autowired
	private OperationLogService operationLogService;
	
	private String officeAll;
	
	@PostConstruct
	public void init(){
		dto = new OperationLogQueryDTO();
	}
	
	public void doQuery(){
		this.verifyData();
		dto.setOperationLogs(operationLogService.getOperationLogList(dto));
	}
	
	private void verifyData(){
		FacesContext context = FacesContext.getCurrentInstance();
		
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

	public OperationLogQueryDTO getDto() {
		return dto;
	}

	public void setDto(OperationLogQueryDTO dto) {
		this.dto = dto;
	}

	public String getOfficeAll() {
		return officeAll;
	}

	public void setOfficeAll(String officeAll) {
		this.officeAll = officeAll;
	}	
	
	
}