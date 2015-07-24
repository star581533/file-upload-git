//http://www.journaldev.com/3229/primefaces-fileupload-component-example-tutorial
package com.iisi.web.fileupload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;









import org.primefaces.model.UploadedFile;

import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.constant.ConstantObject;
import com.iisi.api.domain.FileUploadDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.fileUpload.FileUploadService;
import com.iisi.core.utils.DateUtils;
import com.iisi.web.check.Checker;


@ManagedBean
@ViewScoped
public class FileUploadController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FileUploadDTO dto;
	
	private UploadedFile uploadedFile;
	
	@ManagedProperty(value="#{fileUploadService}")
	private FileUploadService service;
	
	@PostConstruct
	public void init(){
		dto = new FileUploadDTO();		
		dto.setUser(Checker.getUser());		
	}
		
	public void uploadData(){
		System.out.println("uploadData");
		//驗證
//		this.verifyData();
//		//傳檔
		this.doSubmit();
//		//寫值到DB
		service.doSave(dto);
	}
	
	private void verifyData(){
		try{
			FacesContext context = FacesContext.getCurrentInstance();
			//類型
			if(ConstantMethod.verifyColumn(dto.getType())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_TYPE));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_TYPE);
			}
			//密件
			if(ConstantMethod.verifyColumn(dto.getSecret())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_SECRET));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_SECRET);
			}
			//日期
			if(ConstantMethod.verifyColumn(dto.getDisPatchDate().toString())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_DATE));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_DATE);
			}
			//分類號
			if(ConstantMethod.verifyColumn(dto.getClassNum())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_CLASSNUM));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_CLASSNUM);
			}
			//公文文號
			if(ConstantMethod.verifyColumn(dto.getDisPatchNum())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_DISPATCHNUM));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_DISPATCHNUM);
			}
			//主旨
			if(ConstantMethod.verifyColumn(dto.getSubject())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_SUBJECT));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_SUBJECT);
			}
			//檔名
			if(ConstantMethod.verifyColumn(dto.getUploadFile().getFileName())){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_FILE));
				throw new FileSysException(ConstantObject.WARN_MSG_INPUT_FILE);
			}	
		}catch(FileSysException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	public void doSubmit(){
		System.out.println("dto.getDisPatchDate().toString() = " + DateUtils.adToRocDate(dto.getDisPatchDate()));
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		//取得web.xml中所設定目錄
		String directory = externalContext.getInitParameter("uploadDirectory");
		System.out.println("uploadDirectory = " + directory);
		
		String path = externalContext.getRealPath("/");
		System.out.println("path = " + path);
		
		dto.setUploadFile(this.uploadedFile);
		
		//建立會使用到目錄
		List<String> dirPaths = new ArrayList<String>();
		dirPaths.add(path);
		dirPaths.add(directory);
		dirPaths.add(DateUtils.getNowYear());
		dirPaths.add(dto.getUser().getOfficeId());
		dirPaths.add(dto.getUser().getUserId());
		
		this.genDirPath(dirPaths);
		
		dto.setFilePath(DateUtils.getNowYear() + File.separator + dto.getUser().getOfficeId() + File.separator + dto.getUser().getUserId());
		
		//取得檔案名稱
		String fileName = uploadedFile.getFileName();
		//以亂數改檔名
//		String serverName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
		dto.setImageId(DateUtils.getNowDate()+DateUtils.getNowTimeAndMicroSec());
		String serverName = dto.getImageId() + fileName.substring(fileName.lastIndexOf("."));
		
		System.out.println("serverName = " + serverName);
		System.out.println("dto.getFilePath() = " + dto.getFilePath());
		
		try{
			FileOutputStream fileOutputStream = new FileOutputStream(new File(dto.getFullPath(), serverName));
			byte[] buffer = new byte[1024];
			
			int bulk;
			InputStream inputStream = uploadedFile.getInputstream();
			while(true){
				bulk = inputStream.read(buffer);
				if(bulk < 0){
					break;
				}				
				fileOutputStream.write(buffer, 0, bulk);
				fileOutputStream.flush();
			}
			
			fileOutputStream.close();
			inputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
		
	/**
	 * 建立有使用到路徑資料夾
	 * @param dirs
	 */
	private void genDirPath(List<String> dirs){
		StringBuilder dirNames = new StringBuilder();
//		for(String dirName : dirs){
//			dirNames.append(dirName).append(File.separator);
//			this.genDirectory(dirNames.toString());
//		}
		for(int num=0; num < dirs.size();num++){
			String dirName = dirs.get(num);
			if(num == 0){
				dirNames.append(dirName);
			}else{
				dirNames.append(dirName).append(File.separator);
			}
			
			this.genDirectory(dirNames.toString());
		}
		dto.setFullPath(dirNames.toString());
		System.out.println("dto.getFullPath() = " + dto.getFullPath());
	}	
	
	/**
	 * 建立資料夾
	 * @param dirName
	 */
	private void genDirectory(String dirName){
		File dir = new File(dirName);
		if(!dir.exists()){
			dir.mkdir();
		}
	}
	

	
	public FileUploadDTO getDto() {
		return dto;
	}

	public void setDto(FileUploadDTO dto) {
		this.dto = dto;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public FileUploadService getService() {
		return service;
	}

	public void setService(FileUploadService service) {
		this.service = service;
	}
}
