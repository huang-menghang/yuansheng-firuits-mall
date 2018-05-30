package com.ysdevelop.admin.entity;

import com.ysdevelop.common.entity.BaseEntity;

public class Permission extends BaseEntity{
private String permissionName;

private Integer permissionLevel;

private long parentId;

private String permissionDescription;

private Integer status;

public String getPermissionName() {
	return permissionName;
}


public void setPermissionName(String permissionName) {
	this.permissionName = permissionName;
}


public Integer getPermissionLevel() {
	return permissionLevel;
}


public void setPermissionLevel(Integer permissionLevel) {
	this.permissionLevel = permissionLevel;
}


public String getPermissionDescription() {
	return permissionDescription;
}


public void setPermissionDescription(String permissionDescription) {
	this.permissionDescription = permissionDescription;
}


public long getParentId() {
	return parentId;
}


public void setParentId(long parentId) {
	this.parentId = parentId;
}


public Integer getStatus() {
	return status;
}


public void setStatus(Integer status) {
	this.status = status;
}


}

