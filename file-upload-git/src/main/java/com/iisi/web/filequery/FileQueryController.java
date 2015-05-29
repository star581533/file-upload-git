package com.iisi.web.filequery;

import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;






import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.FileQueryDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.fileQuery.FileQueryService;
import com.iisi.web.check.Checker;

@ManagedBean
@ViewScoped
public class FileQueryController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FileQueryDTO dto;
	
	@ManagedProperty(value="#{fileQueryService}")
	private FileQueryService fileQueryService;
	
	private StreamedContent file;
	
	@PostConstruct
	public void init(){
		dto = new FileQueryDTO();
		dto.setUser(Checker.getUser());	
	}
	
	public void doQuery(){
		try{			
			this.verifyData();
			dto.setFiles(fileQueryService.getFileList(dto));
		}catch(FileSysException e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			
		}
	}
	
	public void downloadFile(){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String directory = externalContext.getInitParameter("uploadDirectory");
		String filePath = directory + dto.getFiles().get(0).getList() + ".jpg";
		System.out.println("filePath = " + filePath);
		InputStream stream = ((ServletContext)externalContext.getContext()).getResourceAsStream(filePath);
		file = new DefaultStreamedContent(stream, "image/jpg", dto.getFiles().get(0).getFileName());
//		InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/demo/images/optimus.jpg");
	}
	
	private void verifyData(){
		FacesContext context = FacesContext.getCurrentInstance();
		//類型
		if(null == dto.getType() || dto.getType().length() == 0){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_TYPE));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_TYPE);
		}
		//起始日
		if(null == dto.getStartDate() || dto.getStartDate().toString().length() == 0){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_START_DATE));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_START_DATE);
		}
		//迄止日
		if(null == dto.getEndDate() || dto.getEndDate().toString().length() == 0){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_END_DATE));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_END_DATE);
		}
	}

	public FileQueryDTO getDto() {
		return dto;
	}

	public void setDto(FileQueryDTO dto) {
		this.dto = dto;
	}

	public FileQueryService getFileQueryService() {
		return fileQueryService;
	}

	public void setFileQueryService(FileQueryService fileQueryService) {
		this.fileQueryService = fileQueryService;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}
}
