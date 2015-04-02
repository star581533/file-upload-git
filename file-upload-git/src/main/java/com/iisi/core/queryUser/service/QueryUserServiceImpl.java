package com.iisi.core.queryUser.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.QueryUserDTO;
import com.iisi.api.model.User;
import com.iisi.api.queryUser.QueryUserService;

@Service("queryUserService")
public class QueryUserServiceImpl implements QueryUserService {

	@Inject
	private DBFactory dbFactory;
	
	@Override
	public List<User> getUserList(QueryUserDTO dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from user");
		
		List<String> params = new ArrayList<String>();
		
		List<User> users = (List<User>)dbFactory.query(params, sql.toString(), User.class);
		return users;
	}

}
