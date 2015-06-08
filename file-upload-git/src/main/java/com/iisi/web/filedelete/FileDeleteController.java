package com.iisi.web.filedelete;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.FileDeleteDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.fileDelete.FileDeleteService;
import com.iisi.api.model.FileData;


@ManagedBean
@ViewScoped
public class FileDeleteController implements Serializable {

	private FileDeleteDTO dto;
	
	@ManagedProperty(value="#{fileDeleteService}")
	private FileDeleteService service;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private StreamedContent file;
	
	@PostConstruct
	public void init(){
		dto = new FileDeleteDTO();
	}
	
	public void doQuery(){
		this.verifyData();
		
		dto.setFiles(service.doQuery(dto));
	}
	
	public void downloadFile(FileData data){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String path = externalContext.getRealPath("/upload");
		String fileName = data.getImageId() + ".jpg";
		String filePath = path + File.separator + data.getList() + File.separator+ fileName;
		System.out.println("filePath = " + filePath);
				
	    File result = new File(filePath);
	    
	    System.out.println("result.exists() = " + result.exists());
	    
	    if(result.exists()){
		    InputStream stream;
			try {
				stream = new FileInputStream(result.getAbsolutePath());
				file = new DefaultStreamedContent(stream, "image/jpg", data.getFileName());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}	
	    }else{
	    	throw new FileSysException(ConstantObject.WARN_MSG_INPUT_TYPE);
	    }
	}
	
	public void deleteFile(FileData data){
		dto.setFile(data);	
		
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		String path = externalContext.getRealPath("/upload");
		String fileName = data.getImageId() + ".jpg";
		String filePath = path + File.separator + data.getList() + File.separator+ fileName;
		System.out.println("filePath = " + filePath);
		
		File result = new File(filePath);
		    
		System.out.println("result.exists() = " + result.exists());
		
		if(result.exists()){
			if(result.delete()){
				service.doDelete(dto);
				System.out.println("刪除成功");
			}else{
				System.out.println("刪除失敗");
			}				
		}else{
			System.out.println("資料不存在");
		}		
		
		dto.setFiles(service.doQuery(dto));
		RequestContext.getCurrentInstance().update("resultList");
	}
	
	private void verifyData(){
		
	}

	public FileDeleteDTO getDto() {
		return dto;
	}

	public void setDto(FileDeleteDTO dto) {
		this.dto = dto;
	}

	public FileDeleteService getService() {
		return service;
	}

	public void setService(FileDeleteService service) {
		this.service = service;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}	
}
