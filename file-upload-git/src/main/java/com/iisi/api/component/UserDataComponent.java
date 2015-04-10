package com.iisi.api.component;

import java.util.List;

import com.iisi.api.domain.UserDTO;
import com.iisi.api.model.User;

public interface UserDataComponent {
	
	public List<User> queryUser(UserDTO dto);
	
	public int countSingleUser(UserDTO dto);
	
	public List<User> queryOfficeUsers(UserDTO dto);
	
	public List<User> queryAllUser();
}
