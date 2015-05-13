package com.iisi.api.updatePwd;

import com.iisi.api.domain.UpdatePwdDTO;

public interface UpdatePwdService {
	
	public int checkUser(UpdatePwdDTO dto);
	
	public void updatePassword(UpdatePwdDTO dto);
}
