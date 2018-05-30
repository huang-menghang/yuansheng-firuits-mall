package com.ysdevelop.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.admin.entity.Role;
import com.ysdevelop.admin.service.RoleService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="/role",method=RequestMethod.GET)
    public String role(){
 	   return "role/role";
    }
	
	 @RequestMapping(value="/roleAdd",method=RequestMethod.GET)
     public String addRole(){
  	   return "role/add";
     }
     
     @RequestMapping(value="/roleEdit",method=RequestMethod.GET)
     public String editRole(){
  	   return "role/edit";
     }
     
     @RequestMapping(value="/roleChange",method=RequestMethod.GET)
     public String changeRole(){
  	   return "role/change";
     }
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
    public String list(HttpServletRequest request){
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		Pagination<Role> pagination = new Pagination<>();
		List<Role> roles = roleService.paginationRoles(pagination,queryMap);
    	return JSONHelper.bean2json(Result.successPaginationData(roles,roleService.countRole()));
    }
	
	@RequestMapping(value="/getRole/{id}",method=RequestMethod.GET)
	@ResponseBody
    public Result<String> get(@PathVariable(value="id")Integer id){
		Role role = roleService.getRole(id);
		System.out.println(role.getName());
    	return Result.successData(JSONHelper.bean2json(role));
    }
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	 public Result<String> delete(@PathVariable(value="id") Integer id){
		boolean isDelete = roleService.deleteRole(id);
		if (isDelete) {
			return Result.success("成功");
		}else {
			return Result.success("失败");
		}
    }
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	@ResponseBody
	 public Result<String> add(@RequestBody Map<String, String> message){
		boolean isAdd = roleService.addRole(message);
		if (isAdd) {
			return Result.success("成功");
		}else {
			return Result.success("失败");
		}
    }
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.POST)
	@ResponseBody
	 public Result<String> edit(@RequestBody Map<String, String> message,@PathVariable(value="id")Integer id){
		System.out.println(message+"  "+id);
		boolean isUpdate = roleService.updateRole(message,id);
		return Result.success("成功");
    }
	
	@RequestMapping(value="/changePermission/{id}",method=RequestMethod.POST)
	@ResponseBody
	 public Result<String> changePermission(@RequestBody Map<String, String> message,@PathVariable(value="id")Integer id){
		boolean isAdd = roleService.changePermission(message,id);
		if (isAdd) {
			return Result.success("成功");
		}else {
			return Result.success("失败");
		}
    }
}

