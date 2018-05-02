package com.ysdevelop.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.result.Result;
import com.ysdevelop.shop.annotation.LoginUser;
import com.ysdevelop.shop.entity.Member;
import com.ysdevelop.shop.entity.Order;
import com.ysdevelop.shop.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/newAddress", method = RequestMethod.GET)
	public String newAddress(@LoginUser Member loginMember) {
		return "order/new-address";
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String confirm(@LoginUser Member loginMember) {
		return "order/confirm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Result<Long> add(@RequestParam(value = "ids[]") List<Long> ids, @LoginUser Member loginMember) {
		Long orderId = orderService.add(loginMember, ids);
		return Result.successData(orderId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Result<Order> info(@PathVariable(value = "id") Long orderId, @LoginUser Member loginMember) {
		Order order = orderService.getOrderById(orderId);
		order.setMemberName(loginMember.getName());
		return Result.successData(order);
	}

	@RequestMapping(value = "/changeAddress", method = RequestMethod.PUT)
	@ResponseBody
	public Result<String> changeAddress(@Validated Order order, Boolean defaultAddress, @LoginUser Member loginMember, HttpSession session,
			@CookieValue(value = "token") String token) {
		orderService.changeAddress(order, defaultAddress, loginMember);
		if (defaultAddress) {
		session.setAttribute(token, loginMember);
		}
		return Result.success("修改成功");
	}

}
