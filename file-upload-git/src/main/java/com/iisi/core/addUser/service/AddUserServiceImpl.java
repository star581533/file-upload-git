package com.iisi.core.addUser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisi.api.addUser.AddUserService;
import com.iisi.api.component.UserDataComponent;
import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.AddUserDTO;
import com.iisi.api.domain.UserDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.model.User;
import com.iisi.core.utils.DateUtils;

@Service("addUserService")
public class AddUserServiceImpl implements AddUserService{

	@Autowired
	private transient UserDataComponent userDataComponent;
	
	@Autowired
	private transient DBFactory dbFactory;
	
	@Override
	public void checkUser(AddUserDTO dto) {
		System.out.println("dto.getUserId() = " + dto.getUserId());
		System.out.println("dto.getOfficeId() = " + dto.getOfficeId());
		UserDTO userDto = new UserDTO();
		userDto.setUserId(dto.getUserId());
		userDto.setOfficeId(dto.getOfficeId());
		dto.setUserCount(userDataComponent.countSingleUser(userDto));
	}

	@Override
	public void doSave(AddUserDTO dto) {
		try{
			User user = new User();
			user.setUserId(dto.getUserId());
			user.setUserPwd(dto.getUserId());
			user.setUserName(dto.getUserName());
			user.setLoginFail("0");
			user.setOfficeId(dto.getOfficeId());
			user.setState("Y");
			user.setRoleId(dto.getRoleId());
			user.setCreateDate(DateUtils.getNowDate());
			user.setCreateTime(DateUtils.getNowTime());
			
			dbFactory.insert(user);
		}catch(FileSysException e){
			e.printStackTrace();
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			throw new FileSysException("新增使用者失敗");
		}	
	}

}
