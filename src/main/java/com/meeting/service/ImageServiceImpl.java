package com.meeting.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.meeting.mapper.ImageMapper;
import com.meeting.mapper.MeetingMapper;
import com.meeting.pojo.Image;
import com.meeting.pojo.Meeting;



@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageMapper imageMapper;
	
	@Autowired
	private MeetingMapper meetingMapper;
	/*
	 * 图片上传
	 * */
	@Override
	public Map<String,String> upload(MultipartFile uploadFile) {
		
		Map<String,String> resultMap = new HashMap<String,String>();	
		File picture = null;
		String date=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		//window下的文件目录
		String path = "H:\\Java Web\\pic";
		//linux下的文件目录
		//String path = "/home/ubuntu/xhj/javaweb/pic";
		//文件后缀名
		String fileName = uploadFile.getOriginalFilename();
		int i =fileName.lastIndexOf(".");
		String suffix=fileName.substring(i, fileName.length());
	
		picture=new File(path+"\\","meeting"+date+suffix);
		String url = picture.getName();
			
		//文件上传	
		try {
			uploadFile.transferTo(picture);
			
			resultMap.put("error", "0");
			resultMap.put("url", url);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			resultMap.put("error", "0");
			resultMap.put("url", url);
		} 
		
		
		return resultMap;
		
	}
	/*
	 * 图片的下载
	 * */
	public File download(String filename) {
		// TODO Auto-generated method stub
		File file = new File(filename);
		return file;
	}
	
	//会议照片的上传
	@Override
	public Map meetingImage(MultipartFile file,long mnum) {
		// TODO Auto-generated method stub
		Map<String,String> resultMap = new HashMap<String,String>();	
		File picture = null;
		String date=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		String path = "H:\\Java Web\\pic";
		
		//文件后缀名
		String fileName = file.getOriginalFilename();
		int i =fileName.lastIndexOf(".");
		String suffix=fileName.substring(i, fileName.length());
	
		picture=new File(path+"\\","meeting"+date+suffix);
		String url = picture.getName();
			
		//文件上传	
		try {
			file.transferTo(picture);
			
			resultMap.put("error", "0");
			resultMap.put("url", url);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			resultMap.put("error", "0");
			resultMap.put("url", url);
		} 
		
		Meeting meeting = meetingMapper.selectByPrimaryKey(mnum);
		meeting.setMimage(url);
		meetingMapper.updateByPrimaryKey(meeting);
		
		return resultMap;
	}

}
