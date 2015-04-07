package com.iisi.core.addUser.service;

import com.iisi.api.addUser.AddUserService;
import com.iisi.api.component.UserDataComponent;
import com.iisi.api.domain.AddUserDTO;
import com.iisi.api.domain.UserDTO;

public class AddUserServiceImpl implements AddUserService{

	private transient UserDataComponent userDataComponent;
	
	@Override
	public void checkUser(AddUserDTO dto) {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(dto.getUserId());
		userDto.setOfficeId(dto.getOfficeId());
		userDataComponent.querySingleUser(userDto);
	}

}
