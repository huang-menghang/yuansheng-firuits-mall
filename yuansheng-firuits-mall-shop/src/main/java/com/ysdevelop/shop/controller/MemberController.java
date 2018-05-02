package com.ysdevelop.shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;
import com.ysdevelop.shop.annotation.IgnoreAuth;
import com.ysdevelop.shop.annotation.LoginUser;
import com.ysdevelop.shop.entity.Member;
import com.ysdevelop.shop.service.CartService;
import com.ysdevelop.shop.service.MemberService;
import com.ysdevelop.shop.vo.LoginVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@Autowired
	private CartService cartService;

	@IgnoreAuth
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	@IgnoreAuth
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> doLogin(@Valid LoginVo loginVo, HttpSession session, HttpServletResponse response) {
		System.out.println(loginVo.getMobile() + "  " + loginVo.getPassword());
		Member loginMember = memberService.login(loginVo, session, response);
		cartService.save(loginMember, session);
		System.out.println(loginMember.getCartId());
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

	@RequestMapping(value = "/center", method = RequestMethod.GET)
	public String center() {
		return "member/center";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile() {
		return "member/profile";
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@ResponseBody
	public Result<String> info(@LoginUser Member loginMember) {
		return Result.successData(JSONHelper.bean2json(loginMember));
	}

	@RequestMapping(value = "/info/changeName", method = RequestMethod.GET)
	public String changeName() {
		return "member/change-name";
	}

	@RequestMapping(value = "/set", method = RequestMethod.GET)
	public String set() {
		return "member/set";
	}

	@RequestMapping(value = "/set/aboutus", method = RequestMethod.GET)
	public String aboutus() {
		return "member/about-us";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session, @CookieValue(value = "token") String token) {
		// 移除用户,从定向到首页
		session.removeAttribute(token);
		session.invalidate();
		HttpUtils.redirectUrl(request, response, request.getContextPath() + "/index");
	}

	@RequestMapping(value = "/info/changeName", method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> changeName(String name, @LoginUser Member loginMember, @CookieValue(value = "token") String token, HttpSession session) {
		Integer changeCount = memberService.updateNameAndMobileById(name, null, loginMember.getId());
		String msg = null;
		if (changeCount != null) {
			if (changeCount > 0) {
				msg = "用户名修改成功";
				loginMember.setName(name);
				memberService.refreshSessionMember(session, token, loginMember);
			} else {
				msg = "用户名修改失败";
			}
		}
		return Result.success(msg);
	}

	@RequestMapping(value = "/info/changeMobile", method = RequestMethod.GET)
	public String changeMobile() {
		return "member/change-mobile";
	}

	@RequestMapping(value = "/info/changeMobile", method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> changeMobile(String mobile, @LoginUser Member loginMember, @CookieValue(value = "token") String token, HttpSession session) {
		Integer changeCount = memberService.updateNameAndMobileById(null, mobile, loginMember.getId());
		String msg = null;
		if (changeCount != null) {
			if (changeCount > 0) {
				msg = "用户手机号码修改成功";
				loginMember.setMobile(mobile);
				memberService.refreshSessionMember(session, token, loginMember);
			} else {
				msg = "用户手机号码修改失败";
			}
		}
		return Result.success(msg);
	}

	@RequestMapping(value = "/set/changePassword", method = RequestMethod.GET)
	public String changePassword() {
		return "member/change-pwd";
	}

	@RequestMapping(value = "/set/changePassword", method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> changePassword(@LoginUser Member loginMember, String newPassword, String newConfirmPassword, String oldPassword, HttpSession session,
			@CookieValue(value = "token") String token) {
		String password = memberService.updatePasswordById(newPassword, newConfirmPassword, oldPassword, loginMember);
		loginMember.setPassword(password);
		memberService.refreshSessionMember(session, token, loginMember);
		return Result.success("密码修改成功");
	}

	@RequestMapping(value = "/set/address", method = RequestMethod.GET)
	public String address() {
		return "member/address";
	}

	@RequestMapping(value = "/set/changeAddress", method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> address(Member member, @LoginUser Member loginMember, HttpSession session,@CookieValue(value="token")String token) {
		member.setId(loginMember.getId());
		memberService.updateAddressById(member,loginMember);
		memberService.refreshSessionMember(session, token, loginMember);
		return Result.success("地址修改成功");
	}

}