package com.ysdevelop.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.admin.entity.Role;
import com.ysdevelop.common.page.Pagination;

public interface RoleDao {

	List<Role> listRolesByPagination(@Param(value="pagination")Pagination<Role> pagination);

	Integer countRole();

	boolean deleteRoleById(Integer id);

	void saveRole(@Param(value="roleName")String roleName,@Param(value="roleDescription") String roleDescription);

	Integer getRoleIdByName(String roleName);

	Role getRoleById(Integer id);

	boolean updateRoleById(@Param(value="description")String description, @Param(value="roleName")String roleName,@Param(value="id") Integer id);

}
