package com.iisi.api.addUser;

import com.iisi.api.domain.AddUserDTO;

public interface AddUserService {
	public void checkUser(AddUserDTO dto);

	public void doSave(AddUserDTO dto);
}
