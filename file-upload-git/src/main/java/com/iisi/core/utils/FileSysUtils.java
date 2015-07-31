package com.iisi.core.utils;

import java.io.File;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FileSysUtils {

	/**
	 * 建立資料夾
	 * @param dirName
	 */
	public static void genDirectory(String dirName){
		File dir = new File(dirName);
		if(!dir.exists()){
			dir.mkdir();
		}
	}
	
	/**
	 * 建立有使用到路徑資料夾
	 * @param dirs
	 * @return String
	 */
	public static String genDirPath(List<String> dirs){
		StringBuilder dirNames = new StringBuilder();
		for(String dirName : dirs){
			dirNames.append(dirName).append(File.separator);
			genDirectory(dirNames.toString());
		}
		return dirNames.toString();
	}
	
	/**
	 * 取得上傳初始化路徑
	 * @return
	 */
	public static String getUploadInitDir(){
		//取得環境執行物件
		FacesContext facesContext = FacesContext.getCurrentInstance();
		//利用externalContext取得指定物件
		ExternalContext externalContext = facesContext.getExternalContext();		
		//取得web.xml中所設定目錄
		String directory = externalContext.getInitParameter("uploadDirectory");
		
		return directory;
	}
}
