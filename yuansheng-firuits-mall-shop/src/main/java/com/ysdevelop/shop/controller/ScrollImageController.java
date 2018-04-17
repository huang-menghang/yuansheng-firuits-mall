package com.ysdevelop.shop.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.JSONHelper;
import com.ysdevelop.shop.annotation.IgnoreAuth;
import com.ysdevelop.shop.entity.ScrollImage;
import com.ysdevelop.shop.service.ScrollImageService;

@Controller
@RequestMapping("/scrollImage")
public class ScrollImageController {

	@Autowired
	private ScrollImageService imageService;
    
	@IgnoreAuth
	@RequestMapping(method=RequestMethod.GET,value="")
	@ResponseBody
	public Result<String> index() {
		List<ScrollImage> images = imageService.list();
		return Result.successData(JSONHelper.array2json(images));
	}
}