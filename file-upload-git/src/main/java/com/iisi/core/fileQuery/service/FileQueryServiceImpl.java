package com.iisi.core.fileQuery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.FileQueryDTO;
import com.iisi.api.fileQuery.FileQueryService;
import com.iisi.api.model.FileData;

@Component
@Service("fileQueryService")
public class FileQueryServiceImpl implements FileQueryService {

	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public List<FileData> getFileList(FileQueryDTO dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from filedata");
		
		List<String> params = new ArrayList<String>();
		
		List<FileData> files = (List<FileData>) dbFactory.query(params, sql.toString(), FileData.class);
		
		return files;
	}

}
