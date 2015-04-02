package com.iisi.api.login;

import org.springframework.stereotype.Component;

import com.iisi.api.domain.LoginDTO;

@Component
public interface LoginService {
	public void queryUser(LoginDTO dto);
}
