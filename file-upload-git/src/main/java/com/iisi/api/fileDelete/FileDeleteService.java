package com.iisi.api.fileDelete;

import java.util.List;

import com.iisi.api.domain.FileDeleteDTO;
import com.iisi.api.model.FileData;

public interface FileDeleteService {
	public List<FileData> doQuery(FileDeleteDTO dto);
	
	public void doDelete(FileDeleteDTO dto);
	
}
