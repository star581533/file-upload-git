package com.iisi.api.operationLog;

import java.util.List;

import com.iisi.api.domain.OperationLogQueryDTO;
import com.iisi.api.model.OperationLog;

public interface OperationLogService {
	public List<OperationLog> getOperationLogList(OperationLogQueryDTO dto);
}
