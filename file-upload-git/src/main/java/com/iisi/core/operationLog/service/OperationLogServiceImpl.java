package com.iisi.core.operationLog.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.OperationLogQueryDTO;
import com.iisi.api.model.OperationLog;
import com.iisi.api.operationLog.OperationLogService;
import com.iisi.core.utils.DateUtils;

@Service("operationLogService")
public class OperationLogServiceImpl implements OperationLogService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(OperationLogServiceImpl.class);	
	
	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public List<OperationLog> getOperationLogList(OperationLogQueryDTO dto) {
		LOG.debug("************************* OperationLogServiceImpl getOperationLogList start *************************");
		
		StringBuilder sql = new StringBuilder();
		List<String> params = new ArrayList<String>();
		
		sql.append("select * from operationLog where logdate between ? and ? ");
		params.add(DateUtils.adToRocDate(dto.getStartDate()));
		params.add(DateUtils.adToRocDate(dto.getEndDate()));
		
		if(!ConstantMethod.verifyColumn(dto.getOfficeId())){
			sql.append("and officeid = ? ");
			params.add(dto.getOfficeId());
		}
		
		if(!ConstantMethod.verifyColumn(dto.getUserId())){
			sql.append("and userid = ? ");
			params.add(dto.getUserId());
		}
		
		if(!ConstantMethod.verifyColumn(dto.getUserName())){
			sql.append("and username = ? ");
			params.add(dto.getUserName());
		}
				
		List<OperationLog> operationLogs = (List<OperationLog>)dbFactory.query(params, 
				sql.toString(), OperationLog.class);
		
		LOG.debug("************************* OperationLogServiceImpl getOperationLogList end *************************");
		return operationLogs;
	}

}
