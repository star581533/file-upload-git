package com.iisi.api.user;

import com.iisi.api.domain.LoginDTO;
import com.iisi.api.domain.UserDTO;
import com.iisi.api.model.User;

public interface UserService {
	public User queryUser(UserDTO dto);
}
