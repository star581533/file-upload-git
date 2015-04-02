package com.iisi.web.adduser;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.AddUserDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.user.UserService;


@Controller
@SessionScoped
public class AddUserController implements Serializable {

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
		this.verifyData();
		
		
		
//		FacesContext context = FacesContext.getCurrentInstance();
////		ServletContext servletContext = (ServletContext)context.getExternalContext().getContext();
//		
//		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
//		//destroy session
//		request.getSession().invalidate();
	}
	
	private void verifyData(){		
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			if(ConstantMethod.verifyColumn(dto.getUserId())){
				context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_USER_ID));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_USER_ID);
			}else{
				
			}
			
			if(ConstantMethod.verifyColumn(dto.getUserName())){
				context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_USERNAME));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_USERNAME);
			}	
			
			
		}catch(FileSysException e){
			e.printStackTrace();
		}catch(Exception e){
			
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
		
}
