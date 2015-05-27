//http://www.journaldev.com/3229/primefaces-fileupload-component-example-tutorial

//http://hank20.blogspot.tw/2013/03/jsfprimefaces.html try it

//http://www.28im.com/java/a1243858.html

//http://w3facility.org/question/upload-an-image-to-a-path-set-in-web-xml-using-primefaces/

//http://www.blueshop.com.tw/board/FUM20041006152546UBK/BRD20101109170540YKR.html
package com.iisi.web.uploadTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 



import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Controller;
 
@ManagedBean
@SessionScoped
public class FileUploadTest {
	
    private UploadedFile uploadedFile;
 
    @PostConstruct
    public void init(){
    	URL resource = this.getClass().getResource("");
    	System.out.println("resource = " + resource.toString());
    }
     
    public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	public String dummyAction(){
		System.out.println("Upload file name is :" + uploadedFile.getFileName() + ", Upload file size is:" + uploadedFile.getSize());
		return "";
	}

	
	public void handleFileUpload(FileUploadEvent event){		
		FacesContext context = FacesContext.getCurrentInstance();
		File filesDir = new File(context.getExternalContext().getRealPath("/") + "temp/");
		System.out.println("filesDir.getPath() = " + filesDir.getPath());
				
		if(!filesDir.exists()){
			filesDir.mkdir();
		}else{
			for(File f: filesDir.listFiles()){
				f.delete();
			}
		}
		
		UploadedFile uploadFile = event.getFile();
		String fileName = uploadFile.getFileName();
		String serverName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf('.'));
		
		try{
			OutputStream outputStream = new FileOutputStream(new File(filesDir, serverName));
			byte[] b = new byte[1024];
			int len = 0;
			while((len = uploadFile.getInputstream().read(b)) > 0){
				outputStream.write(b, 0, len);
			}		
			outputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	//OK
	public void submit(){
		System.out.println("Uploaded file name = " + uploadedFile.getFileName());
		System.out.println("Uploaded file size = " + uploadedFile.getSize());
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		//http://w3facility.org/question/upload-an-image-to-a-path-set-in-web-xml-using-primefaces/
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		System.out.println(externalContext.toString());
		//取得web.xml中所設定目錄值
		String directory = externalContext.getInitParameter("uploadDirectory");
		System.out.println("uploadDirectory = " + directory);
		
		String path = externalContext.getRealPath("/upload");
		System.out.println("path = " + path);
		
		
//		File filesDir = new File(context.getExternalContext().getRealPath("/") + "temp/");
//		File filesDir = new File(directory + File.separator + "temp/");
		File filesDir = new File(path + File.separator + "temp" + File.separator);
		System.out.println("filesDir.getPath() = " + filesDir.getPath());
		

		
		if(!filesDir.exists()){
			filesDir.mkdir();
		}
//		else{
//			for(File f: filesDir.listFiles()){
//				f.delete();
//			}
//		}
		
		
		String fileName = uploadedFile.getFileName();
		String serverName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf('.'));
		
		try{
			FileOutputStream fileOutputStream = new FileOutputStream(new File(filesDir, serverName));
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
			
			//將資料寫入指定目錄中
//			OutputStream outputStream = new FileOutputStream(new File(filesDir, serverName));
//			outputStream.write(uploadedFile.getContents());	
//			outputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
//	public void submit(FileUploadEvent event){
//		System.out.println("Uploaded file name = " + uploadedFile.getFileName());
//		System.out.println("Uploaded file size = " + uploadedFile.getSize());
//		
//		FacesContext context = FacesContext.getCurrentInstance();
//		File filesDir = new File(context.getExternalContext().getRealPath("/") + "temp/");
//		System.out.println("filesDir.getPath() = " + filesDir.getPath());
//		
//		if(!filesDir.exists()){
//			filesDir.mkdir();
//		}else{
//			for(File f: filesDir.listFiles()){
//				f.delete();
//			}
//		}
//		
//		UploadedFile uploadFile = event.getFile();
//		long fileSize = uploadFile.getSize();
//		String fileName = uploadFile.getFileName();
//		String serverName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf('.'));
//		
//		try{
//			OutputStream outputStream = new FileOutputStream(new File(filesDir, serverName));
//			byte[] b = new byte[1024];
//			int len = 0;
//			while((len = uploadFile.getInputstream().read(b)) > 0){
//				outputStream.write(b, 0, len);
//			}		
//			outputStream.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
	


//	public void dummyAction(FileUploadEvent event){
//    	System.out.println("upload file start");
//    	byte[] bytes = event.getFile().getContents(); 
//    		System.out.println("Uploaded File Name Is :: "+event.getFile().getFileName()+" :: Uploaded File Size :: "+ bytes.length);
//    }
}