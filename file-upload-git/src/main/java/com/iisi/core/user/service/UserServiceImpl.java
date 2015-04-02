package com.iisi.core.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.LoginDTO;
import com.iisi.api.domain.UserDTO;
import com.iisi.api.model.User;
import com.iisi.api.user.UserService;

@Component
@Qualifier("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public User queryUser(UserDTO dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from user where userid = ?");

		List<String> params = new ArrayList<String>();
		params.add(dto.getUserId());
		
		List<User> users = (List<User>) dbFactory.query(params, sql.toString(), User.class);

		User user = new User();
		
		if(users.size() > 0){
			user = users.get(0);
		}
		
		return user;
	}

}
