package com.iisi.core.updateUser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisi.api.component.UserDataComponent;
import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.UpdateUserDTO;
import com.iisi.api.domain.UserDTO;
import com.iisi.api.model.User;
import com.iisi.api.updateUser.UpdateUserService;

@Service("updateUserService")
public class UpdateUserServiceImpl implements UpdateUserService {

	@Autowired
	private transient UserDataComponent userDataComponent;
	
	private UpdateUserDTO dto;
	
	@Autowired
	private DBFactory dbFactory;
	
	@Override
	public void doQuery(UpdateUserDTO dto) {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(dto.getUserId());
		userDto.setOfficeId(dto.getOfficeId());
		User user = getUser(userDto);
		dto.setUser(user);
	}
	
	private User getUser(UserDTO userDto){
		List<User> users = userDataComponent.queryOneUser(userDto);
		User user = new User();
		if(users.size() > 0){
			user = users.get(0);
		}
		
		System.out.println("users.size() = " + users.size());
		return user;
	}

	@Override
	public void doUpdate(UpdateUserDTO dto) {
		
		dbFactory.update(dto.getUser());
	}	
	
}
