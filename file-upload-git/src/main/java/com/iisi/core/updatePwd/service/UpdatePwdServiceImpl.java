package com.iisi.core.updatePwd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisi.api.component.UserDataComponent;
import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.domain.UpdatePwdDTO;
import com.iisi.api.domain.UserDTO;
import com.iisi.api.model.User;
import com.iisi.api.updatePwd.UpdatePwdService;

@Service("updatePwdService")
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
		userDto.setOfficeId(dto.getOfficeId());
		
		int count = userDataComponent.countSingleUser(userDto);
		
		return count;
	}


	@Override
	public boolean checkUserPassword(UpdatePwdDTO dto) {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(dto.getUserId());
		userDto.setOfficeId(dto.getOfficeId());
		
		List<User> users = userDataComponent.queryUser(userDto);
		User user = users.get(0);
		
		return ConstantMethod.compareTwoColumn(user.getUserPwd(), dto.getOldPassWord());
	}

}
