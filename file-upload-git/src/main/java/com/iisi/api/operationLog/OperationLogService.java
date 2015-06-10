package com.iisi.api.operationLog;

import java.util.List;

import com.iisi.api.domain.OperationLogQueryDTO;
import com.iisi.api.model.OperationLog;

public interface OperationLogService {
	
	/**
	 * 取得操作紀錄資料
	 * @param dto
	 * @return List<OperationLog>
	 */
	public List<OperationLog> getOperationLogList(OperationLogQueryDTO dto);
}
