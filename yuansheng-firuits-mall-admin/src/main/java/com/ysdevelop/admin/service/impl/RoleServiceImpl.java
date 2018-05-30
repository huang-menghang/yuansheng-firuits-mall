package com.ysdevelop.admin.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.admin.entity.Permission;
import com.ysdevelop.admin.entity.Role;
import com.ysdevelop.admin.mapper.RoleDao;
import com.ysdevelop.admin.service.PermissionService;
import com.ysdevelop.admin.service.RolePermissionService;
import com.ysdevelop.admin.service.RoleService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;

@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private RolePermissionService rolePermissionService;

	@Override
	public List<Role> paginationRoles(Pagination<Role> pagination, Map<String, String> queryMap) {
		if (pagination == null || queryMap == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		Integer page = null;
		Integer limit = null;
		if (queryMap == null || (page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {

			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		pagination.setPageNum(page);
		pagination.setPageSize(limit);
		
		Integer count = roleDao.countRole();
		pagination.setTotalItemsCount(count);
		
		List<Role> roles = roleDao.listRolesByPagination(pagination);
		for (int i = 0; i < roles.size(); i++) {
			List<Permission> permissions = permissionService.listPermissionById(roles.get(i).getId());
			roles.get(i).setPermissions(permissions);
		}
		pagination.setItems(roles);
		return roles;
	}

	@Override
	public Integer countRole() {
		return roleDao.countRole();
	}

	@Override
	public boolean deleteRole(Integer id) {
		return roleDao.deleteRoleById(id);
	}

	@Override
	public boolean addRole(Map<String, String> message) {
		String roleDescription =message.get("description");
		String roleName = message.get("roleName");
		Integer id = roleDao.getRoleIdByName(roleName);
		if (id!=null) {
			throw new WebServiceException(CodeMsg.ROLE_EXIST);
		}
		roleDao.saveRole(roleName,roleDescription);
		id = roleDao.getRoleIdByName(roleName);
		Set<String> permissions = message.keySet();
		for (String permission:permissions) {
			if (permission.equals("description")||permission.equals("roleName")) {
				continue;
			}else {
				rolePermissionService.saveRolePermission(id,Integer.valueOf(permission));
			}
		}
		return true;
	}

	@Override
	public Role getRole(Integer id) {
		
		return roleDao.getRoleById(id);
	}

	@Override
	public boolean updateRole(Map<String, String> message,Integer id) {
		return roleDao.updateRoleById(message.get("description"),message.get("roleName"),id);
	}

	@Override
	public boolean changePermission(Map<String, String> message, Integer roleId) {
		Set<String> permissions = message.keySet();
		for(String permissionId:permissions){
			Integer id = rolePermissionService.getRolePermissionById(roleId, Integer.valueOf(permissionId));
			if (id!= null) {
				boolean isChange = rolePermissionService.deleteRolePermission(roleId, Integer.valueOf(permissionId));
				if (!isChange) {
					return true;
				} else {
					continue;
				} 
			}else {
				boolean isChange = rolePermissionService.saveRolePermission(roleId, Integer.valueOf(permissionId));
				if (!isChange) {
					return true;
				} else {
					continue;
				} 
			}
		}
		return true;
	}


}

