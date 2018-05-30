package com.ysdevelop.admin.mapper;

import org.apache.ibatis.annotations.Param;

public interface RolePermissionDao {

	boolean saveRolePermission(@Param(value="roleId")Integer roleId,@Param(value="permissionId") Integer permissionId);

	Integer getRolePermissionById(@Param(value="roleId")Integer roleId,@Param(value="permissionId") Integer permissionId);

	boolean deleteRolePermission(@Param(value="roleId")Integer roleId,@Param(value="permissionId") Integer permissionId);

}
