package com.iisi.web.downloadTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("reqeust")
public class DownloadTest {

	private StreamedContent file;

	@PostConstruct
	public void init(){
		
	}
	
	
//	public DownloadTest(){
//		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//		String directory = externalContext.getInitParameter("uploadDirectory")+ File.separator + "temp/";
//		
////		InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/demo/images/optimus.jpg");
////		String path = externalContext.getRealPath("/upload");
//		try {
//			InputStream stream = new FileInputStream(new File(directory, "test.jpg"));
////			InputStream stream = new FileInputStream(new File(path, "test.jpg"));
//			file = new DefaultStreamedContent(stream, "image/jpg", "test.jpg");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public void downloadFile(){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//		String directory = externalContext.getInitParameter("uploadDirectory")+ File.separator + "temp" + File.separator;
//		System.out.println("directory = " + directory);		
		
//		String path = externalContext.getRealPath("/upload");
//		try {
//			String directory = "/resources/download/";
			InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/download/test.jpg");	
//						InputStream stream = new FileInputStream(new File(directory, "test.jpg"));
//			InputStream stream = new FileInputStream(new File(path, "test.jpg"));
			file = new DefaultStreamedContent(stream, "image/jpg", "test.jpg");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}
}
