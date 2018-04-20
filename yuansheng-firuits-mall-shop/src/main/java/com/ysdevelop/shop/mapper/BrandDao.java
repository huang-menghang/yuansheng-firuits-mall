package com.ysdevelop.shop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.shop.entity.Brand;

public interface BrandDao {
   List<Brand> listByQueryMap(@Param(value="queryMap")Map<String, Object> queryMap);
}
