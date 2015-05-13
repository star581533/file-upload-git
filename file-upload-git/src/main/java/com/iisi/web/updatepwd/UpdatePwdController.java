package com.iisi.web.updatepwd;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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


@ManagedBean
@RequestScoped
public class UpdatePwdController implements Serializable {
	
	private UpdatePwdDTO dto;
	
   
    private transient ExecutantType executant = new ExecutantType();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
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
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		
		User user = (User)request.getSession().getAttribute("user");
		
		System.out.println("user = " + user.toString());
		
		dto.setUserId(user.getUserId());
		dto.setOfficeId(user.getOfficeId());
	}
	
	private String error(){
		return MenuService.LOGIN;
	}
	
	public void saveData(){

	}
	
	private void verifyData(){
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			
			if(ConstantMethod.verifyColumn(dto.getUserId())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_USER_ID));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_USER_ID);
			}

			if(ConstantMethod.verifyColumn(dto.getOldPassWord())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_USER_PWD));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_USER_PWD);
			}
						
			if(ConstantMethod.verifyColumn(dto.getNewPassWord())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_USER_PWD));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_USER_PWD);
			}
			
			if(ConstantMethod.verifyColumn(dto.getConfirmPassWord())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_USER_PWD));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_USER_PWD);
			}
			
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
}
