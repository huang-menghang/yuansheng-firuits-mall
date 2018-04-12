package com.ysdevelop.api.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ysdevelop.api.annotation.IgnoreAuth;
import com.ysdevelop.api.entity.ScrollImage;
import com.ysdevelop.api.shop.service.ScrollImageService;
import com.ysdevelop.common.result.Result;
import com.ysdevelop.common.utils.JSONHelper;

@Controller
@RequestMapping("/scrollImage")
public class ApiScrollImageController {

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
