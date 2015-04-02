package com.iisi.api.fileQuery;

import java.util.List;

import com.iisi.api.domain.FileQueryDTO;
import com.iisi.api.model.FileData;

public interface FileQueryService {
	public List<FileData> getFileList(FileQueryDTO dto);
}
