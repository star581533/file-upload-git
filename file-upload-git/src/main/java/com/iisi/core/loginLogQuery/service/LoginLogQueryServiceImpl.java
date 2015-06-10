package com.iisi.core.loginLogQuery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.LoginLogQueryDTO;
import com.iisi.api.loginLogQuery.LoginLogQueryService;
import com.iisi.api.model.LoginLog;
import com.iisi.core.utils.DateUtils;

@Service("loginLogQueryService")
public class LoginLogQueryServiceImpl implements LoginLogQueryService {

	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public List<LoginLog> getLoginLogList(LoginLogQueryDTO dto) {
		
		StringBuilder sql = new StringBuilder();
		List<String> params = new ArrayList<String>();
		
		sql.append("select * from loginlog where logindate between ? and ? ");
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
		
		List<LoginLog> loginLogs = (List<LoginLog>)dbFactory.query(params, sql.toString(), LoginLog.class);
		
		return loginLogs;
	}

}
