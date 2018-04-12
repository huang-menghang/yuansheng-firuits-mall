package com.ysdevelop.api.shop.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.api.annotation.IgnoreAuth;
import com.ysdevelop.api.entity.Member;
import com.ysdevelop.api.shop.service.MemberService;
import com.ysdevelop.api.vo.LoginVo;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.Constant;

@Controller
@RequestMapping("/member")
public class ApiMemberController {
	@Autowired
	private MemberService memberService;
    
	@IgnoreAuth
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	@IgnoreAuth
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> doLogin(@Valid LoginVo loginVo,HttpSession session,HttpServletResponse response) {
		System.out.println(loginVo.getMobile() + "  " + loginVo.getPassword());
        memberService.login(loginVo,session,response);
		return Result.success("登录成功");

	}

	@IgnoreAuth
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "member/register";
	}
	
	@IgnoreAuth
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> register(@Valid Member member, String confirmPassword, String messageCode, HttpSession session) {
		memberService.save(member, confirmPassword, messageCode, session);
		return Result.success("注册成功");
	}
	
	@IgnoreAuth
	@RequestMapping(value = "/getMobileMsg", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> getMobileMsg(HttpSession session, String mobile) {
		memberService.sendMessage(session, mobile);
		return Result.success("手机验证码发送成功,请注意查收");
	}

	@IgnoreAuth
	@RequestMapping(value = "/invalidateMobileMsg", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> invalidateMobileMsg(HttpSession httpSession) {
		httpSession.removeAttribute(Constant.MOBILE_MSG);
		return Result.success("删除过期msg成功");
	}

	
	@RequestMapping(value="/center",method=RequestMethod.GET)
	public String center(){
		return "member/center";
	}
	
	
}
