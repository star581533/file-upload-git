package com.iisi.web.updateuser;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@ViewScoped
public class UpdateUserAction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;
	
	@PostConstruct
	public void init(){
		System.out.println("~init~");
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		System.out.println("request = " + request);
		System.out.println("request.getParameter(userId) = " + request.getParameter("userId"));
		String userId = String.valueOf(request.getParameter("userId"));
		System.out.println("userId = " + userId);
		this.setUserId(userId);	
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
