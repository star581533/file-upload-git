package com.iisi.api.updateUser;

import com.iisi.api.domain.UpdateUserDTO;

public interface UpdateUserService {
	
	public void doQuery(UpdateUserDTO dto);
	
	public void doUpdate(UpdateUserDTO dto);
}
