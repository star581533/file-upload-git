package com.iisi.core.updatePwd.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iisi.api.component.UserDataComponent;
import com.iisi.api.constant.ConstantMethod;
import com.iisi.api.db.DBFactory;
import com.iisi.api.domain.UpdatePwdDTO;
import com.iisi.api.domain.UserDTO;
import com.iisi.api.execption.FileSysException;
import com.iisi.api.model.User;
import com.iisi.api.updatePwd.UpdatePwdService;

@Service("updatePwdService")
public class UpdatePwdServiceImpl implements UpdatePwdService{
	
	private static Logger LOG = LoggerFactory.getLogger(UpdatePwdServiceImpl.class);

	@Autowired
	private transient UserDataComponent userDataComponent;
	
	private DBFactory dbFactory;
	
	
	@Override
	public void updatePassword(UpdatePwdDTO dto) {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(dto.getUserId());
		userDto.setOfficeId(dto.getOfficeId());
		List<User> users = userDataComponent.queryOneUser(userDto);
		
		try{
			if(users.size() != 0){
				User user = users.get(0);
				user.setUserPwd(dto.getNewPassWord());
				dbFactory.update(user);
			}
		}catch(FileSysException e){
			LOG.error(e.getMessage(), e);
			throw e;
		}catch(Exception e){
			LOG.error(e.getMessage(), e);
			throw new FileSysException("失敗");
		}
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
		
		List<User> users = userDataComponent.queryOneUser(userDto);
		User user = users.get(0);
		
		return ConstantMethod.compareTwoColumn(user.getUserPwd(), dto.getOldPassWord());
	}

}
