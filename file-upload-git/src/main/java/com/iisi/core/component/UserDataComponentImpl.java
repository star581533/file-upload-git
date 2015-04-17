package com.iisi.core.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iisi.api.component.UserDataComponent;
import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.UserDTO;
import com.iisi.api.model.User;

@Component("userDataComponent")
public class UserDataComponentImpl implements UserDataComponent{

	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public List<User> queryUser(UserDTO dto){
		StringBuilder sql = new StringBuilder();
		sql.append("select * from user where userid = ? and officeid = ?");

		List<String> params = new ArrayList<String>();
		params.add(dto.getUserId());
		params.add(dto.getOfficeId());
		
		List<User> users = (List<User>) dbFactory.query(params, sql.toString(), User.class);
	
		return users;
	}
	

	@Override
	public int countSingleUser(UserDTO dto) {
		int count = this.queryUser(dto).size();
		return count;
	}

	@Override
	public List<User> queryOfficeUsers(UserDTO dto) {
		List<String> params = new ArrayList<String>();
		StringBuilder sql = new StringBuilder();
		
		sql.append("select * from user where officeid = ? ");		
		params.add(dto.getOfficeId());
		
		if(!ConstantMethod.verifyColumn(dto.getState())){
			sql.append("and state = ?");
			params.add(dto.getState());
		}
		
		List<User> users = (List<User>) dbFactory.query(params, sql.toString(), User.class);
		return users;
	}


	@Override
	public List<User> queryAllUser(UserDTO dto) {
		List<String> params = new ArrayList<String>();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from user ");
		if(!ConstantMethod.verifyColumn(dto.getState())){
			sql.append("where state = ? ");
			params.add(dto.getState());
		}	
		System.out.println("query All User sql = " + sql.toString());
		List<User> users = (List<User>) dbFactory.query(params, sql.toString(), User.class);
		
		return users;

	}

}
