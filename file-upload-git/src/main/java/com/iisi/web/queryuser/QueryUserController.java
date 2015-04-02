//http://www.mkyong.com/jsf2/jsf-2-dropdown-box-example/
package com.iisi.web.queryuser;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.QueryUserDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.menu.MenuService;
import com.iisi.api.queryUser.QueryUserService;



@Controller
@SessionScoped
public class QueryUserController  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private QueryUserDTO dto;
	
	private String officeAll;
					
	@Autowired
	private QueryUserService queryUserService;	
	
	@PostConstruct
	public void init(){
		dto = new QueryUserDTO();
	}
	
		
	public void queryButton(){
		System.out.println("queryButton");
		
		FacesContext context = FacesContext.getCurrentInstance();
//		ServletContext servletContext = (ServletContext)context.getExternalContext().getContext();
		
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		//destroy session
		request.getSession().invalidate();
		
		this.verifyData();
		
		dto.setUsers(queryUserService.getUserList(dto));
	}
	
	public void userDataLink(ActionEvent event){

	}
		
	private void verifyData(){
		FacesContext context = FacesContext.getCurrentInstance();
		//��O
//		if(dto.getOfficeId() == null || dto.getOfficeId().length() == 0){
//			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_OFFICE));
//			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_OFFICE);			
//		}
		
		//�b¾���A
		if(dto.getState() == null || dto.getState().length() == 0){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_STATE));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_STATE);
		}
	}
	
	public String userForward(){
		return MenuService.UPDATE_USER;
	}


	public QueryUserDTO getDto() {
		return dto;
	}


	public void setDto(QueryUserDTO dto) {
		this.dto = dto;
	}


	public String getOfficeAll() {
		return officeAll;
	}


	public void setOfficeAll(String officeAll) {
		this.officeAll = officeAll;
	}		
}
