package com.ysdevelop.api.shop.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.api.entity.Member;
import com.ysdevelop.api.shop.service.MemberService;
import com.ysdevelop.api.vo.LoginVo;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.result.Result;

@Controller
@RequestMapping("/user")
public class ApiUserController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> doLogin(@Valid LoginVo loginVo) {
		System.out.println(loginVo.getMobile()+"  "+loginVo.getPassword());
		if(loginVo.getPassword().equals("123456")){
			return Result.success("登录成功");
		}
		else{
			return Result.error(CodeMsg.PASSWORD_WRONG);
		}
		
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(){
		return "user/register";
	}
	
	@RequestMapping(value="/register",method =  RequestMethod.POST )
	@ResponseBody
	public Result<String> register(@Valid Member member,String confirmPassword){
		memberService.save(member,confirmPassword);
		return Result.success("测试成功");
	}
	
	@RequestMapping(value="/getMobileMsg",method=RequestMethod.POST)
	@ResponseBody
	public Result<String> getMobileMsg(HttpSession session,String mobile){
		memberService.sendMessage(session);
		return null;
	}

}
