//http://www.fanli7.net/a/bianchengyuyan/C__/20121128/219636.html
package com.iisi.web.uploadTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.stereotype.Controller;

@Controller
@SessionScoped
public class DataImportBackBean {
	/**
	 * serialVersionUID:TODO
	 * 
	 * @since Ver 1.1
	 */

	private static final long serialVersionUID = 4598429926870056176L;


	@PostConstruct
	public void initView() {
		this.doInitView();
	}

	/**
	 * 初始化视图.
	 */
	private void doInitView() {

	}
/**
 * 上傳xls
 * @param event
 */
	public void handleFileUpload(FileUploadEvent event) {
		System.out.println("====================" + event.getFile().getFileName());
		FacesContext context = FacesContext.getCurrentInstance();
		File filesDir = new File(context.getExternalContext().getRealPath("/")
				+ "temp/");
		System.out.println("filesDir.getPath() = " + filesDir.getPath());
		if (!filesDir.exists()) {
			filesDir.mkdir();
		} else {
			for (File f : filesDir.listFiles()) {
				f.delete();
			}
		}

		UploadedFile wrappedUploadedFile = event.getFile();
		long fileSize = wrappedUploadedFile.getSize();
		String reallyName = wrappedUploadedFile.getFileName();
		String serverName = UUID.randomUUID().toString()
				+ reallyName.substring(reallyName.lastIndexOf('.'));
		try {
			OutputStream outputStream = new FileOutputStream(new File(filesDir, serverName));
			outputStream.write(wrappedUploadedFile.getContents());
			
//			byte[] b = new byte[1024];
//			int len = 0;
//			while((len = wrappedUploadedFile.getInputstream().read(b)) > 0){
//				outputStream.write(b, 0, len);
//			}
//			
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
