package com.ysdevelop.shop.mapper;

import org.apache.ibatis.annotations.Param;

public interface GoodsFavDao {
	Integer save(@Param(value = "memberId") Long memberId, @Param(value = "goodsId") Long goodsId);
}
