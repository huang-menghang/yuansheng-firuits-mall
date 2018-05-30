package com.ysdevelop.admin.service;

public interface RolePermissionService {

	boolean saveRolePermission(Integer id, Integer valueOf);

	Integer getRolePermissionById(Integer roleId, Integer valueOf);

	boolean deleteRolePermission(Integer roleId, Integer valueOf);

}
