package com.ysdevelop.admin.entity;

import java.util.List;

import com.ysdevelop.common.entity.BaseEntity;

public class Role extends BaseEntity{

private String name;

private String description;

private List<Permission> permissions;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public List<Permission> getPermissions() {
	return permissions;
}

public void setPermissions(List<Permission> permissions) {
	this.permissions = permissions;
}

}

