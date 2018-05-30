package com.ysdevelop.admin.service;

import java.util.List;
import java.util.Map;

import com.ysdevelop.admin.entity.Role;
import com.ysdevelop.common.page.Pagination;

public interface RoleService {

	List<Role> paginationRoles(Pagination<Role> pagination, Map<String, String> queryMap);

	Integer countRole();

	boolean deleteRole(Integer id);

	boolean addRole(Map<String, String> message);

	Role getRole(Integer id);

	boolean updateRole(Map<String, String> message, Integer id);

	boolean changePermission(Map<String, String> message, Integer roleId);

}

