package com.iisi.api.loginLogQuery;

import java.util.List;

import com.iisi.api.domain.LoginLogQueryDTO;
import com.iisi.api.model.LoginLog;

public interface LoginLogQueryService {
	public List<LoginLog> getLoginLogList(LoginLogQueryDTO dto);
}
