package com.iisi.api.component;

import java.util.List;

import com.iisi.api.domain.UserDTO;
import com.iisi.api.model.User;

public interface UserDataComponent {
	public User querySingleUser(UserDTO dto);
	
	public int countUser(UserDTO dto);
	
	public List<User> officeUsers(UserDTO dto);
}
