//http://www.journaldev.com/3229/primefaces-fileupload-component-example-tutorial
package com.iisi.web.fileupload;

import java.io.File;
import java.io.FileOutputStream;
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
@RequestScoped
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
		//驗證
		this.verifyData();
		//傳檔
		this.doSubmit();
		//寫值到DB
		service.doSave(dto);
	}
	
	private void verifyData(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(ConstantMethod.verifyColumn(dto.getType())){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_TYPE));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_TYPE);
		}
		
		if(ConstantMethod.verifyColumn(dto.getSecret())){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_SECRET));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_SECRET);
		}
		
		if(ConstantMethod.verifyColumn(dto.getDisPatchDate())){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_DATE));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_DATE);
		}
		
		if(ConstantMethod.verifyColumn(dto.getClassNum())){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_CLASSNUM));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_CLASSNUM);
		}
		
		if(ConstantMethod.verifyColumn(dto.getDisPatchNum())){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_DISPATCHNUM));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_DISPATCHNUM);
		}
		
		if(ConstantMethod.verifyColumn(dto.getSubject())){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_SUBJECT));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_SUBJECT);
		}
		
		if(ConstantMethod.verifyColumn(dto.getUploadFile().getFileName())){
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, ConstantObject.INPUT_DATA, ConstantObject.WARN_MSG_INPUT_FILE));
			throw new FileSysException(ConstantObject.WARN_MSG_INPUT_FILE);
		}		
	}
	
	public void doSubmit(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		//取得web.xml中所設定目錄
		String directory = externalContext.getInitParameter("uploadDirectory");
		
		//建立會使用到目錄
		List<String> dirPaths = new ArrayList<String>();
		dirPaths.add(directory);
		dirPaths.add(DateUtils.getNowYear());
		dirPaths.add(dto.getUser().getOfficeId());
		dirPaths.add(dto.getUser().getUserId());
		
		this.genDirPath(dirPaths);
		
		//取得檔案名稱
		String fileName = uploadedFile.getFileName();
		//
		String serverName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
		
		try{
			//將資料寫入指定目錄中
			OutputStream outputStream = new FileOutputStream(new File(dto.getFileData().getList(), serverName));
			//寫檔案
			outputStream.write(uploadedFile.getContents());
			//關檔案
			outputStream.close();
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
		for(String dirName : dirs){
			dirNames.append(dirName).append(File.separator);
			this.genDirectory(dirNames.toString());
		}
		dto.getFileData().setList(dirNames.toString());
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
	
//	public static void main(String args[]){
//		new FileUploadController().test();
//	}
//	
//	public void test(){
//		String dirFirst = "C:\\Users\\1104611\\Desktop\\";
//		String dirSecond = "dir";
//		String dirThird = "104";
//		String dirFourth = "001";
//		String dirFifth = "test";
//
//		List<String> dirs = new ArrayList<String>();
//		dirs.add(dirFirst);
//		dirs.add(dirSecond);
//		dirs.add(dirThird);
//		dirs.add(dirFourth);
//		dirs.add(dirFifth);
//		
//		this.genDirPath(dirs);
//	}
	
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
