package com.iisi.web.loginlogquery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.LoginLogQueryDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.loginLogQuery.LoginLogQueryService;
import com.iisi.api.model.Office;
import com.iisi.api.office.OfficeService;

@Controller
@RequestScoped
public class LoginLogQueryController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LoginLogQueryDTO dto;
	
	@Autowired
	private LoginLogQueryService loginLogQueryService;
	
	private String officeAll;
	
	@Autowired
	private OfficeService officeService;
	
	@PostConstruct
	public void init(){
		dto = new LoginLogQueryDTO();
//		List<SelectItem> items = officeService.getOfficeItems();
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
	
	
}
