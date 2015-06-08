package com.iisi.core.fileDelete.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.FileDeleteDTO;
import com.iisi.api.fileDelete.FileDeleteService;
import com.iisi.api.model.FileData;
import com.iisi.core.utils.DateUtils;

@Service("fileDeleteService")
public class FileDeleteServiceImpl implements FileDeleteService {

	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public List<FileData> doQuery(FileDeleteDTO dto) {
		StringBuilder sql = new StringBuilder();
		List<String> params = new ArrayList<String>();
		
		sql.append("select * from filedata ");
		sql.append("where uploaddate between ? and ? ");
		sql.append("and type = ? ");
		
		params.add(DateUtils.adToRocDate(dto.getStartDate()));
		params.add(DateUtils.adToRocDate(dto.getEndDate()));
		params.add(dto.getType());
		
		if(!ConstantMethod.verifyColumn(dto.getSecret())){
			sql.append("and secret = ? ");
			params.add(dto.getSecret());
		}
		
		if(!ConstantMethod.verifyColumn(dto.getClassNum())){
			sql.append("and classnum = ? ");
			params.add(dto.getClassNum());
		}
		
		if(!ConstantMethod.verifyColumn(dto.getDisPatchNum())){
			sql.append("and dispatchnum = ? ");
			params.add(dto.getDisPatchNum());
		}
		
		if(!ConstantMethod.verifyColumn(dto.getSubject())){
			sql.append("and subject = ? ");
			params.add(dto.getSubject());
		}
		
		if(!ConstantMethod.verifyColumn(dto.getGovernment())){
			sql.append("and government = ? ");
			params.add(dto.getGovernment());
		}
		
		List<FileData> files = (List<FileData>)dbFactory.query(params, sql.toString(), FileData.class);
		
		return files;
	}

	@Override
	public void doDelete(FileDeleteDTO dto) {
		FileData file = dto.getFile();
		dbFactory.delete(file);
	}

}
