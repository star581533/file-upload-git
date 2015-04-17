package com.iisi.web.loginlogquery;

import java.io.Serializable;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.LoginLogQueryDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.loginLogQuery.LoginLogQueryService;

@ManagedBean
@ViewScoped
public class LoginLogQueryController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LoginLogQueryDTO dto;
	
	@ManagedProperty(value = "#{loginLogQueryService}")
	private LoginLogQueryService loginLogQueryService;
	
	private String officeAll;
	
	
	@PostConstruct
	public void init(){
		dto = new LoginLogQueryDTO();
	}

	public void doQuery(){
		this.verifyData();
		dto.setLoginLogs(this.loginLogQueryService.getLoginLogList(dto));
	}
	
	public void doPrint(){
		
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

	public LoginLogQueryDTO getDto() {
		return dto;
	}

	public void setDto(LoginLogQueryDTO dto) {
		this.dto = dto;
	}

	public String getOfficeAll() {
		return officeAll;
	}

	public void setOfficeAll(String officeAll) {
		this.officeAll = officeAll;
	}

	public LoginLogQueryService getLoginLogQueryService() {
		return loginLogQueryService;
	}

	public void setLoginLogQueryService(LoginLogQueryService loginLogQueryService) {
		this.loginLogQueryService = loginLogQueryService;
	}	
}
