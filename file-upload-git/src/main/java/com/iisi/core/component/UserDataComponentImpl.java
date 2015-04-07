package com.iisi.core.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iisi.api.component.UserDataComponent;
import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.UserDTO;
import com.iisi.api.model.User;

@Component
public class UserDataComponentImpl implements UserDataComponent{

	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public User querySingleUser(UserDTO dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from user where userid = ? and officeid = ?");

		List<String> params = new ArrayList<String>();
		params.add(dto.getUserId());
		params.add(dto.getOfficeId());
		
		List<User> users = (List<User>) dbFactory.query(params, sql.toString(), User.class);

		User user = new User();		
		if(users.size() > 0){
			user = users.get(0);
		}		
		return user;
	}

	@Override
	public int countUser(UserDTO dto) {
		int count = this.countUser(dto);		
		return count;
	}

	@Override
	public List<User> officeUsers(UserDTO dto) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from user where userid = ? and officeid = ?");

		List<String> params = new ArrayList<String>();
		params.add(dto.getUserId());
		params.add(dto.getOfficeId());
		
		List<User> users = (List<User>) dbFactory.query(params, sql.toString(), User.class);
		return users;
	}

}
