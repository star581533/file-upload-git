package com.iisi.core.util;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;

import org.springframework.beans.factory.annotation.Qualifier;

import com.iisi.api.model.ExecutantType;
import com.iisi.api.model.UserType;
import com.iisi.api.util.FileSysUserUtil;

@ApplicationScoped
@Qualifier("fileSysUtilImpl")
public class FileSysUtilImpl implements FileSysUserUtil, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public UserType getUser() {
		return UserUtil.getUser();
	}

	@Override
	public ExecutantType getExecutant() {
		System.out.println("FileSysUtilImpl getExecutant------------------------------------------------------------");
		return UserUtil.getExecutant();
	}

	@Override
	public String getUserId() {
		return null;
	}

	@Override
	public String getOfficeId() {
		return null;
	}

}
