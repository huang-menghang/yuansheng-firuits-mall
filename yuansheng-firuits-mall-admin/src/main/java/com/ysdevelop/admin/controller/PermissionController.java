package com.ysdevelop.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.admin.entity.Permission;
import com.ysdevelop.admin.service.PermissionService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;

@Controller

@RequestMapping("/permission")
public class PermissionController {
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping(value="/permission",method=RequestMethod.GET)
	public String PermissionList(){
		return "permission/permission-list";
	}
	
	@RequestMapping(value = "/pagination",method = RequestMethod.GET)
	@ResponseBody
	public String pagination(HttpServletRequest request) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		Pagination<Permission> pagination = new Pagination<>();
		permissionService.paginationByQueryMap(pagination,queryMap);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(),pagination.getTotalItemsCount()));
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	@ResponseBody
	public Result<String> listPermission() {
		List<Permission> permissions = permissionService.listPermissions();
		return Result.successData(JSONHelper.array2json(permissions));
	}
	
	@RequestMapping(value="/ishave/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Result<String> listPermissionByRole(@PathVariable(value="id")Long id) {
		Map<String,List<Permission>> permissions = permissionService.listPermissionRoleHave(id);
		return Result.successData(JSONHelper.bean2json(permissions));
	}
	
	@RequestMapping(value="/category/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Result<String> listPermissionByParentId(@PathVariable(value="id")Long id) {
		System.out.println(id);
		List<Permission> permissions = permissionService.listPermissionByParent(id);getClass();
		System.out.println(permissions.size());
		return Result.successData(JSONHelper.array2json(permissions));
	}
	
	@RequestMapping(value = "/delete/batch",method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> deleteBatch(@RequestParam(value = "ids[]",required = false) List<Long> ids){
		
		permissionService.deleteBatchByIds(ids);
		return Result.success("操作成功");
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> delete(@PathVariable(value = "id") Long id) {
		permissionService.deleteById(id);
		return Result.success("操作成功");
	} 
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		return "permission/info";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result<Permission> info(@PathVariable(value = "id") Long id) {

		Permission memberInfo = permissionService.getInfoById(id);

		return Result.successData(memberInfo);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit() {
		return "permission/edit";
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.POST)
	@ResponseBody
    public Result<String > editPermission(@PathVariable(value = "id") Long id,@RequestParam Map<String, String> queryMap) {
		System.out.println("哈哈哈哈哈");
		permissionService.editById(id,queryMap);
        return Result.success("操作成功");
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public String add() {

		return "permission/insert";
	}
	
    @RequestMapping(value="/insert",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> insertPermission(@RequestParam Map<String, String> queryMap){
    	permissionService.insertItem(queryMap);
    	return Result.success("添加成功");
    }
    
    @RequestMapping(value="/permissionType",method=RequestMethod.GET)
    public String permissionType(){
 	   return "permission/permissiontype";
    }
}

