package com.iisi.core.loginLogQuery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.LoginLogQueryDTO;
import com.iisi.api.loginLogQuery.LoginLogQueryService;
import com.iisi.api.model.LoginLog;

@Service("loginLogQueryService")
public class LoginLogQueryServiceImpl implements LoginLogQueryService {

	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public List<LoginLog> getLoginLogList(LoginLogQueryDTO dto) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * from loginlog");
		
		List<String> params = new ArrayList<String>();
		
		List<LoginLog> loginLogs = (List<LoginLog>)dbFactory.query(params, sql.toString(), LoginLog.class);
		
		return loginLogs;
	}

}
