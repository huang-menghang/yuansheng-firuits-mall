package com.ysdevelop.api.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.api.entity.ScrollImage;
import com.ysdevelop.api.shop.mapper.ScrollImageDao;
import com.ysdevelop.api.shop.service.ScrollImageService;

@Service
public class SrollImageServiceImpl implements ScrollImageService {

	@Autowired
	private ScrollImageDao imageDao;

	@Override
	public List<ScrollImage> list() {
		return imageDao.list();
	}

}
