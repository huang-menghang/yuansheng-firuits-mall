package com.ysdevelop.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.admin.mapper.RolePermissionDao;
import com.ysdevelop.admin.service.RolePermissionService;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

	
	@Autowired
	private RolePermissionDao rolePermissionDao;
	@Override
	public boolean saveRolePermission(Integer id, Integer permissionId) {
		return rolePermissionDao.saveRolePermission(id, permissionId);
	}

	@Override
	public Integer getRolePermissionById(Integer roleId, Integer permissionId) {
		return rolePermissionDao.getRolePermissionById(roleId, permissionId);
	}

	@Override
	public boolean deleteRolePermission(Integer roleId, Integer permissionId) {
		return rolePermissionDao.deleteRolePermission(roleId, permissionId);
	}

}
