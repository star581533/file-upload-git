package com.iisi.core.operationLog.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.OperationLogQueryDTO;
import com.iisi.api.model.OperationLog;
import com.iisi.api.operationLog.OperationLogService;

@Service("operationLogService")
public class OperationLogServiceImpl implements OperationLogService, Serializable {

	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public List<OperationLog> getOperationLogList(OperationLogQueryDTO dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from operationLog");
		
		List<String> params = new ArrayList<String>();
		
		List<OperationLog> operationLogs = (List<OperationLog>)dbFactory.query(params, 
				sql.toString(), OperationLog.class);
		
		return operationLogs;
	}

}
