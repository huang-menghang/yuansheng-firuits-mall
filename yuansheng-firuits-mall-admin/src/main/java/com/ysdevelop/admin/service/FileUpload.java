package com.ysdevelop.admin.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.ysdevelop.admin.entity.ScrollImage;

public interface FileUpload {
	
	public ScrollImage upload(MultipartFile file) throws IOException;
}
