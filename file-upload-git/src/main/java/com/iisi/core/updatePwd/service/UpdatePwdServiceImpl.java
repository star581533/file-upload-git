package com.iisi.core.updatePwd.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.iisi.api.component.UserDataComponent;
import com.iisi.api.domain.UpdatePwdDTO;
import com.iisi.api.domain.UserDTO;
import com.iisi.api.updatePwd.UpdatePwdService;

public class UpdatePwdServiceImpl implements UpdatePwdService{

	@Autowired
	private transient UserDataComponent userDataComponent;
	
	
	@Override
	public void updatePassword(UpdatePwdDTO dto) {
		
	}


	@Override
	public int checkUser(UpdatePwdDTO dto) {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(dto.getUserId());
		userDto.setOfficeId(dto.getUserId());
		
		int count = userDataComponent.countSingleUser(userDto);
		
		return count;
	}

}
