package com.iisi.web.updatepwd;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;







import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.UpdatePwdDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.menu.MenuService;
import com.iisi.api.model.ExecutantType;
import com.iisi.api.model.User;
import com.iisi.api.updatePwd.UpdatePwdService;
import com.iisi.web.check.Checker;


@ManagedBean
@RequestScoped
public class UpdatePwdController implements Serializable {
	
	private UpdatePwdDTO dto;
	
   
    private transient ExecutantType executant = new ExecutantType();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{updatePwdService}")
	private UpdatePwdService service;
		
//	@Autowired
//	@Inject
//    private transient FileSysUserUtil fileSysUserUtil;
	
	@PostConstruct
	public void init(){
//		System.out.println("executant = " + this.executant);
//		System.out.println("fileSysUserUtil.getExecutant() = " + this.fileSysUserUtil.getExecutant());
//		
//		this.executant = this.fileSysUserUtil.getExecutant();
				
		
		dto = new UpdatePwdDTO();
		
//		FacesContext context = FacesContext.getCurrentInstance();
//		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
//		
//		User user = (User)request.getSession().getAttribute("user");
		User user = Checker.getUser();
		if(user != null){
			System.out.println("user = " + user.toString());
			
			dto.setUserId(user.getUserId());
			dto.setOfficeId(user.getOfficeId());
		}else{
			this.error();
		}
	}
	
	public String error(){
		System.out.println("error");
		return MenuService.LOGIN;
	}
	
	public void saveData(){
		this.verifyData();
				
//		service.updatePassword(dto);
		
	}
	
	private void verifyData(){
		try{
			FacesContext context = FacesContext.getCurrentInstance();

			if(ConstantMethod.verifyColumn(dto.getOldPassWord())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_OLD_PASSWORD));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_OLD_PASSWORD);
			}
						
			if(ConstantMethod.verifyColumn(dto.getNewPassWord())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_NEW_PASSWORD));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_NEW_PASSWORD);
			}
			
			if(ConstantMethod.verifyColumn(dto.getConfirmPassWord())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_CONFIRM_PASSWORD));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_CONFIRM_PASSWORD);
			}
			
			//比對新密碼與確認密碼要相同
			if(!ConstantMethod.compareTwoColumn(dto.getNewPassWord(), dto.getConfirmPassWord())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_NEW_CONFIRM_PASSWORD));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_NEW_CONFIRM_PASSWORD);
			}
			
			//比對新舊密碼是否相同
			if(ConstantMethod.compareTwoColumn(dto.getOldPassWord(), dto.getNewPassWord())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_USER_PWD));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_USER_PWD);
			}
//			//
//			if(service.checkUser(dto) == 0){
//				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ConstantObject.INPUT_DATA, ConstantObject.ERROR_MSG_USER_NOT_EXIST));
//				throw new FileSysException(ConstantObject.ERROR_MSG_USER_NOT_EXIST);
//			}
		}catch(FileSysException e){
			System.out.println(e.getMessage());
		}	
	}
	
	public UpdatePwdDTO getDto() {
		return dto;
	}

	public void setDto(UpdatePwdDTO dto) {
		this.dto = dto;
	}

	public UpdatePwdService getService() {
		return service;
	}

	public void setService(UpdatePwdService service) {
		this.service = service;
	}
	
}
