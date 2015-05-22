package com.iisi.core.login.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.LoginDTO;
import com.iisi.api.login.LoginService;
import com.iisi.api.model.User;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public void queryUser(LoginDTO dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from user where userid = ?");

		List<String> params = new ArrayList<String>();
		params.add(dto.getUserId());
		
		List<User> users = (List<User>) dbFactory.query(params, sql.toString(), User.class);

		//		List<User> users = new ArrayList<User>();
		
		if(users.size() == 0){
			dto.setCheckLogin(false);
		}else{
			User user = new User();
			user.setOfficeId(users.get(0).getOfficeId());
			user.setRoleId(users.get(0).getRoleId());
			user.setState(users.get(0).getState());
			user.setUserId(users.get(0).getUserId());
			user.setUserName(users.get(0).getUserName());
			dto.setUser(user);
			dto.setCheckLogin(true);
		}
	}

}
