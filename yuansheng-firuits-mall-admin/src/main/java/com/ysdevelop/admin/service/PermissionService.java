package com.ysdevelop.admin.service;

import java.util.List;
import java.util.Map;

import com.ysdevelop.admin.entity.Permission;
import com.ysdevelop.common.page.Pagination;

public interface PermissionService {

	List<Permission> listPermissionById(Long id);

	List<Permission> listPermissions();

	Map<String,List<Permission>> listPermissionRoleHave(Long roleId);

	List<Permission> listPermissionByParent(Long id);
	
	void paginationByQueryMap(Pagination<Permission> pagination,Map<String, String> queryMap);
	
	void deleteBatchByIds(List<Long> ids);
	
	void deleteById(Long id);

	Permission getInfoById(Long id);
	
	void editById(Long id,Map<String, String> queryMap);

	void insertItem(Map<String, String> queryMap);
}
