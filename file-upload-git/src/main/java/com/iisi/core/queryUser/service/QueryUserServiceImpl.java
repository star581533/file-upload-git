package com.iisi.core.queryUser.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisi.api.component.UserDataComponent;
import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.QueryUserDTO;
import com.iisi.api.domain.UserDTO;
import com.iisi.api.model.User;
import com.iisi.api.queryUser.QueryUserService;

@Service("queryUserService")
public class QueryUserServiceImpl implements QueryUserService {
	
	@Autowired
	private transient UserDataComponent userDataComponent;
	
	@Override
	public List<User> getUserList(QueryUserDTO dto) {
		List<User> users = new ArrayList<User>();
		
		if(ConstantMethod.verifyColumn(dto.getOfficeId())){
			users = userDataComponent.queryAllUser();
		}else{
			UserDTO userDto = new UserDTO();
			userDto.setOfficeId(dto.getOfficeId());
			userDto.setState(dto.getState());
			users = userDataComponent.queryOfficeUsers(userDto);
		}	
		return users;
	}

}
