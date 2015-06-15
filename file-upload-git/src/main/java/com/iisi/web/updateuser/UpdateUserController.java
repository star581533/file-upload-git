package com.iisi.web.updateuser;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

import com.iisi.api.domain.UpdateUserDTO;
import com.iisi.api.updateUser.UpdateUserService;


@ManagedBean
@ViewScoped
public class UpdateUserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UpdateUserDTO dto;
	
	@ManagedProperty(value = "#{updateUserService}")
	private UpdateUserService service;
	
	@PostConstruct
	public void init(){
		dto = new UpdateUserDTO();
		this.getWebParameUserId();
	}
	
	public void doPwdReset(){
		
	}
	
	public void doReset(){
		String userId = dto.getUserId();
		String officeId = dto.getOfficeId();
		dto = new UpdateUserDTO();
		this.queryUser(userId, officeId);
	}
	
	public void doUpdate(){
		service.doQuery(dto);
	}
	
	private void getWebParameUserId(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String userId = request.getParameter("id");
		String officeId = request.getParameter("officeid");
		this.queryUser(userId, officeId);

	}
	
	private void queryUser(String userId, String officeId){
		dto.setUserId(userId);
		dto.setOfficeId(officeId);		
		this.service.doQuery(dto);
	}

	

	public UpdateUserDTO getDto() {
		return dto;
	}

	public void setDto(UpdateUserDTO dto) {
		this.dto = dto;
	}

	public UpdateUserService getService() {
		return service;
	}

	public void setService(UpdateUserService service) {
		this.service = service;
	}
}
