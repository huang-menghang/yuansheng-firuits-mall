package com.ysdevelop.api.shop.service.impl;

import javax.servlet.http.HttpSession;

import org.quartz.simpl.RAMJobStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.api.entity.Member;
import com.ysdevelop.api.shop.mapper.MemberDao;
import com.ysdevelop.api.shop.service.MemberService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Md5Util;
import com.ysdevelop.common.utils.RandomUtil;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public void save(Member member, String confirmPassword) {
		// 通过盐值加密
		if (member == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		if (memberDao.countByMobile(member.getMobile()) > 0) {
			throw new WebServiceException(CodeMsg.MOBILE_EXIST);
		}

		if (member.getPassword() != confirmPassword) {
			throw new WebServiceException(CodeMsg.PASSWORD_CONFIRM);
		}

		member.setPassword(Md5Util.inputPassToDbPass(member.getPassword()));
		memberDao.save(member);
	}

	@Override
	public void sendMessage(HttpSession session) {
		String randomNumber = RandomUtil.randomNumber(6);
        

	
	
	}

}
