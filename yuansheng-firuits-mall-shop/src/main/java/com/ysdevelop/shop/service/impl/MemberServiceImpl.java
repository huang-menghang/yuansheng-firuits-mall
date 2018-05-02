package com.ysdevelop.shop.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;
import com.ysdevelop.common.utils.Md5Util;
import com.ysdevelop.common.utils.RandomUtil;
import com.ysdevelop.common.utils.SendMobeliMessageUtil;
import com.ysdevelop.common.utils.UUIDUtil;
import com.ysdevelop.shop.entity.Member;
import com.ysdevelop.shop.mapper.MemberDao;
import com.ysdevelop.shop.service.MemberService;
import com.ysdevelop.shop.vo.LoginVo;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public void save(Member member, String confirmPassword, String message, HttpSession httpSession) {
		// 通过盐值加密
		if (member == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		if (memberDao.countByMobile(member.getMobile()) > 0) {
			throw new WebServiceException(CodeMsg.MOBILE_EXIST);
		}
		System.out.println();
		if (!member.getPassword().equals(confirmPassword)) {
			throw new WebServiceException(CodeMsg.PASSWORD_CONFIRM);
		}
		if (message == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		if (!message.equals(httpSession.getAttribute(Constant.MOBILE_MSG))) {
			throw new WebServiceException(CodeMsg.MESSAGE_CODE_WRONG);
		}

		member.setPassword(Md5Util.inputPassToDbPass(member.getPassword()));
		memberDao.save(member);
	}

	@Override
	public void sendMessage(HttpSession session, String mobile) {
		String randomNumber = RandomUtil.randomNumber(6);
		session.setAttribute(Constant.MOBILE_MSG, randomNumber);
		// 发送消息给用户的手机
		SendMobeliMessageUtil.sendSms(randomNumber, mobile, null);
	}

	@Override
	public Member login(LoginVo loginVo, HttpSession session, HttpServletResponse response) {
		Member memberLogin = memberDao.getByMobile(loginVo.getMobile());
		if (memberLogin == null) {
			throw new WebServiceException(CodeMsg.MEMBER_WRONG);
		}

		if (!Md5Util.formPassToDBPass(loginVo.getPassword()).equals(memberLogin.getPassword())) {
			throw new WebServiceException(CodeMsg.PASSWORD_WRONG);
		}
		// 将用户放在缓存中,redis,session,cookie
		// 随机生成uuid
		String token = UUIDUtil.uuid();
		addCookie(session, response, memberLogin, token);
		return memberLogin;
	}

	@Override
	public Integer updateNameAndMobileById(String name, String mobile, Long id) {
		Integer changeCount = memberDao.updateNameAndMobileById(name, mobile, id);
		return changeCount;
	}

	private void addCookie(HttpSession session, HttpServletResponse response, Member member, String token) {
		session.setAttribute(token, member);
		Cookie cookie = new Cookie(Constant.TOKEN_NAME, token);
		cookie.setMaxAge(session.getMaxInactiveInterval() - 200);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	@Override
	public void refreshSessionMember(HttpSession session, String token, Member member) {
		session.setAttribute(token, member);
	}

	@Override
	public String updatePasswordById(String newPassword, String newConfirmPassword, String oldPassword, Member member) {
		if (newPassword == null || newConfirmPassword == null || oldPassword == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}

		if (!newPassword.equals(newConfirmPassword)) {
			throw new WebServiceException(CodeMsg.PASSWORD_CONFIRM);
		}

		if (Md5Util.inputPassToDbPass(newPassword).equals(member.getPassword())) {
			throw new WebServiceException(CodeMsg.NEWOLDPASSWOR_SAME);
		}

		if (!Md5Util.formPassToDBPass(oldPassword).equals(member.getPassword())) {
			throw new WebServiceException(CodeMsg.OLDPASSWORD_WRONG);
		}
		String dbPassword = Md5Util.inputPassToDbPass(newConfirmPassword);
		memberDao.updatePasswordById(dbPassword, member.getId());

		return dbPassword;
	}

	@Override
	public void updateAddressById(Member member,Member loginMember) {
		if(member == null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		memberDao.updateAddressById(member);
		loginMember.setProvince(member.getProvince());
		loginMember.setCity(member.getCity());
		loginMember.setTown(member.getTown());
		loginMember.setDetailAddress(member.getDetailAddress());
	}

}