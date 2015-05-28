package com.iisi.core.fileUpload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.FileUploadDTO;
import com.iisi.api.fileUpload.FileUploadService;
import com.iisi.api.model.FileData;
import com.iisi.core.utils.DateUtils;

@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService{

	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public void doSave(FileUploadDTO dto) {
		FileData fileData = new FileData();
		fileData.setClassNum(dto.getClassNum());
		fileData.setDisPatchDate(DateUtils.adToRocDate(dto.getDisPatchDate()));
		fileData.setDisPatchNum(dto.getDisPatchNum());
		fileData.setFileName(dto.getUploadFile().getFileName());
		fileData.setGovernment(dto.getGovernment());
		fileData.setImageId(dto.getImageId());
		fileData.setList(dto.getFilePath());
		fileData.setOfficeId(dto.getUser().getOfficeId());
		fileData.setRoleId(dto.getUser().getRoleId());
		fileData.setSecret(dto.getSecret());
		fileData.setSubject(dto.getSubject());
		fileData.setType(dto.getType());
		fileData.setUploadDate(DateUtils.getNowDate());
		fileData.setUploadTime(DateUtils.getNowTime());
		fileData.setUserId(dto.getUser().getUserId());
		fileData.setUserName(dto.getUser().getUserName());
		
		dbFactory.insert(fileData);
	}
}
