package com.ysdevelop.shop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.ysdevelop.common.entity.BaseEntity;
import com.ysdevelop.common.validate.IsMobile;
import com.ysdevelop.common.validate.IsTelephone;

public class Order extends BaseEntity {

	// 订单用户id
	private Integer memberId;
	// 订单的用户名
	private String memberName;
	// 用户订单列表
	private List<OrderItem> orderItems = new ArrayList<>();
	// 最新更新时间
	private Date lastUpdateTime;
	// 订单中的记录数
	private Integer totalItemCount;
	// 订单中的总的商品数
	private Integer totalItemNo = 0;
	// 订单总价
	private Double orderTotalPrice;
	// 订单实付款
	private Double orderDisbursement;
	@NotEmpty(message = "详细地址不能为空")
	private String orderDetailAddress;
	@NotEmpty(message = "请选择省市")
	private String memberProvince;
	@NotEmpty(message = "请选择省市")
	private String memberCity;
	private String memberDist;
	@NotEmpty(message = "手机号码不能为空")
	@IsMobile
	private String memberMobile;
	@NotEmpty(message = "电话号码不能为空")
	@IsTelephone
	private String memberPhone;
	// 备注
	private String orderRemark;
	// 订单状态 0-待付款 1-已付款 2-待收货 -3-完成-4-销毁
	private Integer orderStatus;
	// 0-支付宝 1-微信
	private Integer orderPayment;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getTotalItemCount() {
		return totalItemCount;
	}

	public void setTotalItemCount(Integer totalItemCount) {
		this.totalItemCount = totalItemCount;
	}

	public Integer getTotalItemNo() {
		return totalItemNo;
	}

	public void setTotalItemNo(Integer totalItemNo) {
		this.totalItemNo = totalItemNo;
	}

	public Double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(Double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public Double getOrderDisbursement() {
		return orderDisbursement;
	}

	public void setOrderDisbursement(Double orderDisbursement) {
		this.orderDisbursement = orderDisbursement;
	}

	public String getOrderDetailAddress() {
		return orderDetailAddress;
	}

	public void setOrderDetailAddress(String orderDetailAddress) {
		this.orderDetailAddress = orderDetailAddress;
	}

	public String getMemberProvince() {
		return memberProvince;
	}

	public void setMemberProvince(String memberProvince) {
		this.memberProvince = memberProvince;
	}

	public String getMemberCity() {
		return memberCity;
	}

	public void setMemberCity(String memberCity) {
		this.memberCity = memberCity;
	}

	public String getMemberDist() {
		return memberDist;
	}

	public void setMemberDist(String memberDist) {
		this.memberDist = memberDist;
	}

	public String getMemberMobile() {
		return memberMobile;
	}

	public void setMemberMobile(String memberMobile) {
		this.memberMobile = memberMobile;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderPayment() {
		return orderPayment;
	}

	public void setOrderPayment(Integer orderPayment) {
		this.orderPayment = orderPayment;
	}

}
