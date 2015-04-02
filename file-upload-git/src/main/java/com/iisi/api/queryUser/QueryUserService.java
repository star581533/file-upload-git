package com.iisi.api.queryUser;

import java.util.List;

import com.iisi.api.domain.QueryUserDTO;
import com.iisi.api.model.User;

public interface QueryUserService {

	public List<User> getUserList(QueryUserDTO dto);
}
