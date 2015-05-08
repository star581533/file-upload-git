package com.iisi.web.updatepwd;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iisi.api.domain.UpdatePwdDTO;
import com.iisi.api.menu.MenuService;
import com.iisi.api.model.User;

@ManagedBean
@RequestScoped
public class UpdatePwdController implements Serializable {
	
	private UpdatePwdDTO dto;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@PostConstruct
	public void init(){
		dto = new UpdatePwdDTO();
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		
		User user = (User)request.getSession().getAttribute("user");
		
		System.out.println("user = " + user.toString());
		
		dto.setUserId(user.getUserId());
		
	}
	
	private String error(){
		return MenuService.LOGIN;
	}
	
	public void saveData(){

	}
	
//	private void verifyData(){
//		
//	}

	public UpdatePwdDTO getDto() {
		return dto;
	}

	public void setDto(UpdatePwdDTO dto) {
		this.dto = dto;
	}	
}
