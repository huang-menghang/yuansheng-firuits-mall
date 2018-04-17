package com.ysdevelop.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.shop.entity.ScrollImage;
import com.ysdevelop.shop.mapper.ScrollImageDao;
import com.ysdevelop.shop.service.ScrollImageService;


@Service
public class SrollImageServiceImpl implements ScrollImageService {

	@Autowired
	private ScrollImageDao imageDao;

	@Override
	public List<ScrollImage> list() {
		return imageDao.list();
	}

}
