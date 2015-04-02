package com.iisi.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	private String roleId = null;
	
	private String roleName;

	@Id
	@Column(name="roleid", unique=true, nullable=false)
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name="rolename", unique=false, nullable=false)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("roleId = ").append(this.roleId).append(", ");
		sb.append("roleName = ").append(this.roleName);
		
		return sb.toString();
	}
	
}
