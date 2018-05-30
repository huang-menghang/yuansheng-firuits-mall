package com.ysdevelop.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.admin.entity.Permission;
import com.ysdevelop.common.page.Pagination;

public interface PermissionDao {

	List<Permission> listPermissionById(Long id);

	List<Permission> listPermission();

	List<Permission> listPermissionRoleNotHave(@Param(value="roleHave")List<Permission> roleHave);

	List<Permission> listPermissionByParentId(Long parentId);
	
	Integer countByQueryMap(@Param(value="queryMap")Map<String, String> queryMap);
	
	List<Permission> paginationByQueryMap(@Param(value="pagination")Pagination<Permission> pagination,@Param (value="queryMap")Map<String,String> queryMap);

	void deleteBatchByIds(List<Long> ids);
	
	void updateStatusById(Long id);
	
	Permission getInfoById(Long id);

	void editById(@Param(value="id")Long id, @Param(value="queryMap")Map<String, String> queryMap);

	void insertItem(@Param(value="queryMap")Map<String, String> queryMap);
}