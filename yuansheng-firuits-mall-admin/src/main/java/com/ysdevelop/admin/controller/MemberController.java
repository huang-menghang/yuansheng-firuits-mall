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

import com.ysdevelop.admin.entity.Member;
import com.ysdevelop.admin.service.MemberService;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.HttpUtils;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index() {
		return "member/index";
	}

	@RequestMapping(value = "/pagination", method = RequestMethod.GET)
	@ResponseBody
	public String pagination(HttpServletRequest request) {
		Map<String, String> queryMap = HttpUtils.getParameterMap(request);
		Pagination<Member> pagination = new Pagination<>();
		memberService.paginationByQueryMap(pagination, queryMap);
		return JSONHelper.bean2json(Result.successPaginationData(pagination.getItems(), pagination.getTotalItemsCount()));

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> delete(@PathVariable(value = "id") Long id) {
		memberService.deleteById(id);
		return Result.success("操作成功");
	}

	@RequestMapping(value = "/delete/batch", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<String> deleteBatch(@RequestParam(value = "ids[]", required = false) List<Long> ids) {
		memberService.deleteBatchByIds(ids);
		return Result.success("操作成功");
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String info() {
		return "member/info";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result<Member> info(@PathVariable(value = "id") Long id) {

		Member memberInfo = memberService.getInfoById(id);

		return Result.successData(memberInfo);
	}

}
