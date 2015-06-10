package com.iisi.api.component;

import java.util.List;

import com.iisi.api.domain.UserDTO;
import com.iisi.api.model.User;

public interface UserDataComponent {
	
	/**
	 * 查詢單一使用者資料
	 * @param dto
	 * @return
	 */
	public List<User> queryOneUser(UserDTO dto);
	
	/**
	 * 查詢使用者帳號數
	 * @param dto UserDTO
	 * @return int
	 */
	public int countSingleUser(UserDTO dto);
	
	/**
	 * 查詢某科別使用者
	 * @param dto UserDTO
	 * @return List<User>
	 */
	public List<User> queryOfficeUsers(UserDTO dto);
	
	/**
	 * 查詢所有使用者資料
	 * @param dto UserDTO
	 * @return List<User>
	 */
	public List<User> queryAllUser(UserDTO dto);
}
