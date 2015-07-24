package com.iisi.web.adduser;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;

import com.iisi.api.addUser.AddUserService;
import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.AddUserDTO;
import com.iisi.api.execption.FileSysException;

@ManagedBean
@RequestScoped
public class AddUserController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AddUserDTO dto;
	
	private List<SelectItem> officeList = new ArrayList<SelectItem>();	
		
	@ManagedProperty(value="#{addUserService}")
	private AddUserService addUserService;
	
	@PostConstruct
	public void init(){	
		dto = new AddUserDTO();
	}
	
	public void doSave(){		
		System.out.println("doSave");
		
		this.verifyData();
		
		if(dto.getUserCount() > 0){
			this.addUserService.doSave(dto);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "新增成功", "使用者新增成功"));
			RequestContext.getCurrentInstance().update("growl");
		}else{
			throw new FileSysException("資料已存在");
		}
		

	}
	
	private void verifyData(){		
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			if(ConstantMethod.verifyColumn(dto.getUserId())){
				context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_USER_ID));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_USER_ID);
			}else{
				this.addUserService.checkUser(dto);
				if(dto.getUserCount() > 0){
					context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, ConstantObject.AGAIN_INPUT_DATA, ConstantObject.WARN_MSG_INPUT_USER_ID));
					throw new FileSysException(ConstantObject.WARN_MSG_INPUT_USER_ID);
				}
			}
			
			if(ConstantMethod.verifyColumn(dto.getUserName())){
				context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, ConstantObject.INPUT_DATA, ConstantObject.ERROR_MSG_USER_EXIST));
				throw new FileSysException(ConstantObject.ERROR_MSG_USER_EXIST);
			}			
		}catch(FileSysException e){
			e.printStackTrace();
		}	
	}
	
	public void userDataListener(){
		System.out.println("userdataListener userId = " + dto.getUserId());
		System.out.println("userdataListener officeId = " + dto.getOfficeId());
		this.addUserService.checkUser(dto);		
		if(dto.getUserCount() > 0){
			dto.setUserConfirm("使用者帳號已存在");
		}else{
			dto.setUserConfirm("使用者帳號未使用");
		}
	}

	public AddUserDTO getDto() {
		return dto;
	}

	public void setDto(AddUserDTO dto) {
		this.dto = dto;
	}

	public List<SelectItem> getOfficeList() {
		return officeList;
	}

	public void setOfficeList(List<SelectItem> officeList) {
		this.officeList = officeList;
	}

	public AddUserService getAddUserService() {
		return addUserService;
	}

	public void setAddUserService(AddUserService addUserService) {
		this.addUserService = addUserService;
	}
}
