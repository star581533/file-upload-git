package com.iisi.web.operationlogquery;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.OperationLogQueryDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.operationLog.OperationLogService;


@ManagedBean
@ViewScoped
public class OperationLogQueryController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OperationLogQueryDTO dto;
	
	@ManagedProperty(value="#{operationLogService}")
	private OperationLogService operationLogService;
		
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

	public OperationLogService getOperationLogService() {
		return operationLogService;
	}

	public void setOperationLogService(OperationLogService operationLogService) {
		this.operationLogService = operationLogService;
	}	
}