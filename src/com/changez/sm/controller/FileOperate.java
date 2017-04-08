package com.changez.sm.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.changez.sm.base.bean.Customer;
import com.changez.sm.service.FileService;

/**
 * @desc: 
 * @auth: zona
 * 2017年1月8日 下午12:05:15
 */
@Controller
@RequestMapping("/file/operate/")
public class FileOperate {

	@Resource
	private FileService fileService;
	
	@RequestMapping("upload")
	@ResponseBody
	public void upload(MultipartFile sources, HttpServletRequest request, String user) throws IllegalStateException, IOException {
			
		//原始名称
		String originalFilename = sources.getOriginalFilename();
		//上传图片
		if(sources!=null && originalFilename!=null && originalFilename.length()>0){
			
			//存储图片的物理路径
			String pic_path = "E:\\images\\wechat\\";
			
			//新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(pic_path+newFileName);
			
			//将内存中的数据写入磁盘
			sources.transferTo(newFile);
		}
//		fileService.saveFiles(movieList);
			
	}
	
	@RequestMapping("uploadmore")
	@ResponseBody
    public String  springUpload(HttpServletRequest request, String name) throws IllegalStateException, IOException{
		
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
             String n = multiRequest.getParameter("name");// 获取指定的普通表单内容， 也可以在在方法参数中获取到 
             Map<String, String[]> map = multiRequest.getParameterMap(); // 获取普通表单封装后的map对象
            while(iter.hasNext()) {
                // 获取上传文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null) {
                    String path="E:\\images\\mvctest\\"+file.getOriginalFilename();
                    // 写到磁盘
                    file.transferTo(new File(path));
                }
            }
        }
        return "success"; 
    }
	
	// 不能正常使用
	@RequestMapping("swf/uploadFile")
	public void swfUpload(HttpServletRequest request) throws IllegalStateException, IOException {

        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)) {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
             String n = multiRequest.getParameter("name");// 获取指定的普通表单内容， 也可以在在方法参数中获取到 
             Map<String, String[]> map = multiRequest.getParameterMap(); // 获取普通表单封装后的map对象
            while(iter.hasNext()) {
                // 获取上传文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null) {
                    String path="E:\\images\\mvctest\\"+file.getOriginalFilename();
                    // 写到磁盘
                    file.transferTo(new File(path));
                }
            }
        }
	}
	
	@RequestMapping("plupload/uploadFile")
	public void plupload(HttpServletRequest request) throws IllegalStateException, IOException {
		
		//将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
		
		//检查form中是否有enctype="multipart/form-data"
		if(multipartResolver.isMultipart(request)) {
			//将request变成多部分request
			MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
			//获取multiRequest 中所有的文件名
			Iterator iter=multiRequest.getFileNames();
			String n = multiRequest.getParameter("name");// 获取指定的普通表单内容， 也可以在在方法参数中获取到 
			Map<String, String[]> map = multiRequest.getParameterMap(); // 获取普通表单封装后的map对象
			while(iter.hasNext()) {
				// 获取上传文件
				MultipartFile file=multiRequest.getFile(iter.next().toString());
				if(file!=null) {
					String path="E:\\images\\mvctest\\"+file.getOriginalFilename();
					// 写到磁盘
					file.transferTo(new File(path));
				}
			}
		}
	}
	
	public void downLoadOne(String imgPath) {/*
		String whole = "E:\\images\\wechat\\"+imgPath;
		 try {
	            // path是指欲下载的文件的路径。
	            File file = new File(whole);
	            // 取得文件名。
	            String filename = file.getName();
	            // 取得文件的后缀名。
	            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

	            // 以流的形式下载文件。
	            InputStream fis = new BufferedInputStream(new FileInputStream(whole));
	            byte[] buffer = new byte[fis.available()];
	            fis.read(buffer);
	            fis.close();
	            // 清空response
	            response.reset();
	            // 设置response的Header
	            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
	            response.addHeader("Content-Length", "" + file.length());
	            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	            response.setContentType("application/octet-stream");
	            toClient.write(buffer);
	            toClient.flush();
	            toClient.close();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        return response;
	*/}
	@RequestMapping("download")
	public ResponseEntity<byte[]> download(String fileName) throws IOException {
		if(fileName == null || fileName.length() ==0) {
			return null;
		}
		String imgRoot = "E:\\images\\";
		File file = new File(imgRoot+fileName);
		String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1"); 
		HttpHeaders headers = new HttpHeaders(); 
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
		headers.setContentDispositionFormData("attachment", dfileName); 
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED); 
	}

}
