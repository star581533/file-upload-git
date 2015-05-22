package com.iisi.api.util;

import com.iisi.api.model.ExecutantType;
import com.iisi.api.model.UserType;

public abstract interface FileSysUserUtil {
	public abstract UserType getUser();

	public abstract ExecutantType getExecutant();

	public abstract String getUserId();

	public abstract String getOfficeId();
}
