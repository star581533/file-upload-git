//http://www.mkyong.com/jsf2/jsf-2-0-spring-hibernate-integration-example/

package com.iisi.web.login;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;




import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.LoginDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.login.LoginService;

@ManagedBean
@RequestScoped
public class LoginController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginDTO dto;
	
	private String message;	
	
//	@Autowired
	@ManagedProperty(value="#{loginService}")
	private LoginService loginService;
	
	@PostConstruct
	public void init(){
		dto = new LoginDTO();
	}
	
	public String loginButton(){	
		this.verify();
		
		if(dto.isCheckLogin()){
			if(dto.getUserId().equals(dto.getUser().getUserId())){
				FacesContext context = FacesContext.getCurrentInstance();
				HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
				request.getSession().setAttribute("userId", dto.getUser().getUserId());
				request.getSession().setAttribute("userName", dto.getUser().getUserName());
				request.getSession().setAttribute("user", dto.getUser());
				return "index.xhtml?faces-redirect=true";
			}
		}
		return null;
	}
		
	/**
	 * 執行資料驗證
	 * @throws FileUploadException 
	 */
	private void verify() {
		try{
			
			FacesContext context = FacesContext.getCurrentInstance();
			//檢核使用者帳號
			if(null == dto.getUserId() || dto.getUserId().length() == 0){
				context.addMessage("Warn", new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_USER_ID));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_USER_ID);
			}
			//檢核使用者密碼
			if(null == dto.getPassword() || dto.getPassword().length() == 0){
				context.addMessage("Warn", new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_USER_PWD));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_USER_PWD);
			}
						
			this.loginService.queryUser(dto);
			
			if(!dto.isCheckLogin()){
				if(null == dto.getUser()){
					context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_USER_ERR));
					throw new FileSysException(ConstantObject.WARN_MSG_USER_ERR);
				}else{					
					context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_USER_PWD_ERR));
					throw new FileSysException(ConstantObject.WARN_MSG_USER_PWD_ERR);
				}
			}			
		}catch(FileSysException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void cancelButton(){
		dto = new LoginDTO();
	}

	public LoginDTO getDto() {
		return dto;
	}

	public void setDto(LoginDTO dto) {
		this.dto = dto;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}	
}
