package com.ysdevelop.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.admin.entity.Permission;
import com.ysdevelop.admin.mapper.PermissionDao;
import com.ysdevelop.admin.service.PermissionService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.CodeMsg;

@Service
public class PermissionServiceImpl implements PermissionService{
	
@Autowired
private PermissionDao permissionDao;

	@Override
	public List<Permission> listPermissionById(Long id) {
		
		return permissionDao.listPermissionById(id);
	}

	@Override
	public List<Permission> listPermissions() {
		return permissionDao.listPermission();
	}

	@Override
	public Map<String,List<Permission>> listPermissionRoleHave(Long roleId) {
	    List<Permission> roleHave = permissionDao.listPermissionById(roleId);
	    Map<String, List<Permission>> permissions = new HashMap<>();
	    permissions.put("roleHave", roleHave);
	    List<Permission > roleNotHave = permissionDao.listPermissionRoleNotHave(roleHave);
	    permissions.put("roleNotHave", roleNotHave);
		return permissions;
	}

	@Override
	public List<Permission> listPermissionByParent(Long id) {
		return permissionDao.listPermissionByParentId(id);
	}
	
	@Override
	public void paginationByQueryMap(Pagination<Permission> pagination,Map<String, String> queryMap){
		if (pagination == null || queryMap == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		
		Integer page = null;
		Integer limit = null;
		if ((page = Integer.valueOf(queryMap.get("page"))) == null || (limit = Integer.valueOf(queryMap.get("limit"))) == null) {

			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
	    pagination.setPageNum(page);
	    pagination.setPageSize(limit);
		Integer count = permissionDao.countByQueryMap(queryMap);
		pagination.setTotalItemsCount(count);
		List<Permission> memberItems = permissionDao.paginationByQueryMap(pagination,queryMap);
		pagination.setItems(memberItems);
	}
	
	@Override
	public void deleteBatchByIds(List<Long> ids) {
		if (ids == null || ids.size() == 0) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		permissionDao.deleteBatchByIds(ids);
	}
	
	@Override
	public void deleteById(Long id) {
		if(id == null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		permissionDao.updateStatusById(id);
	}
	
	@Override
	public void editById(Long id,Map<String, String> queryMap){
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		permissionDao.editById(id,queryMap);
		
	}
	
	@Override
	public void insertItem(Map<String, String> queryMap){
		permissionDao.insertItem(queryMap);
	}

	@Override
	public Permission getInfoById(Long id){
		if (id == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Permission memberInfo = permissionDao.getInfoById(id);
		return memberInfo;
	}
}
