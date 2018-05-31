package com.ysdevelop.admin.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ysdevelop.admin.entity.ScrollImage;
import com.ysdevelop.admin.service.FileUpload;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;

@Service
public class FileUploadImpl implements FileUpload{
    
	
	@Override
	public ScrollImage upload(MultipartFile file) throws IOException {
		if(file ==null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		int size = (int) file.getSize();
		String name = file.getOriginalFilename();
		System.out.println("图片原始名称： "+name);
		String[] arrs = name.split("\\.");
		for(String arr : arrs){
			System.out.println("arr : "+arr);
		}
		String pathName = "."+name.split("\\.")[1];
		
		System.out.println("pathName : "+pathName);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date = new Date();
		String dateName = dateFormat.format(date);
		
		String fileName = dateName+pathName;
		String path = "E:\\image";
		if(!file.isEmpty()){
				FileUtils.copyInputStreamToFile(file.getInputStream(),new File(path,fileName));
		}
		 
		String filePath = Constant.IMAGE_PATH ;
		ScrollImage scrollImage = new ScrollImage();
		System.out.println("file image 正要创建 ！");
		File image = new File(filePath,fileName);
		if(!image.exists()){
			image.createNewFile();
		}
		FileOutputStream fileOutputStream =new FileOutputStream(image);
		int length = -1;
		   InputStream inputStream = file.getInputStream();
		while((length=inputStream.read())!=-1){
			fileOutputStream.write(length);
			fileOutputStream.flush();
		}
		inputStream.close();
		fileOutputStream.close();
		System.out.println("202020");
		String imageUrl = Constant.IMAGE_URL+"\\"+fileName;
        System.out.println("imageUrl : "+imageUrl);
		scrollImage.setImageUrl(imageUrl);
		return scrollImage;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public String upload(byte[] in,String filePath, String fileName) {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String fileNameDate = dateFormat.format(new Date());
       
		try {

            int len = 0;

            String path = this.getClass().getClassLoader().getResource("").getPath();

            //获得tomacatwebapp路径

            String pathtest = path.replace("lib", "webapps");

            String picRealPath = pathtest + filePath;

            //判断文件夹是否存在，不存在的话创建文件夹

            File filecheck = new File(picRealPath);

            if (!filecheck.exists()){

                filecheck.mkdirs();

            }// 检查上载文件的目录是否存在

            File df = new File(picRealPath + fileName);

            FileOutputStream out = new FileOutputStream(df,true);  

            len = in.length;

            out.write(in,0,len);

            out.close();

        } catch (Exception e) {

            e.getMessage();

        }

        return null;

    }*/

	
		
}
