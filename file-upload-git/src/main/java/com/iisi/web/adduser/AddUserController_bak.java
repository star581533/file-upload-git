package com.iisi.web.adduser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;




import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iisi.api.domain.AddUserDTO;
import com.iisi.api.office.OfficeService;

@Controller
@SessionScoped
public class AddUserController_bak implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AddUserDTO dto;
	
	private List<SelectItem> officeList = new ArrayList<SelectItem>();	
	
	@PostConstruct
	public void init(){
//		ServletContext servletContext = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
//		
//		String path = servletContext.getRealPath(File.separator + "");
//		
//		System.out.println("path = " + path);
//		
//		InputStream stream = getClass().getResourceAsStream("/main/resources/office.properties");
//		
//		BufferedReader br = null;
//		
//		StringBuilder sb = new StringBuilder();
//		
//		String length = "";
//		
//		br = new BufferedReader(new InputStreamReader(stream));
//		
//        try {
//			while((length = br.readLine()) != null) { 
//			    sb.append(length);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally{
//			if(br != null){
//				try {
//					br.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//        
//        System.out.println(sb);
		
		
		dto = new AddUserDTO();
		
		Properties properties = new Properties();
//		try {
//			properties.load(new FileInputStream("./src/main/resources/office"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void doSave(){
		System.out.println("doSave");
		FacesContext context = FacesContext.getCurrentInstance();
//		ServletContext servletContext = (ServletContext)context.getExternalContext().getContext();
		
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		//destroy session
		request.getSession().invalidate();
	}
	
	private void verifyData(){
		
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
		
}
