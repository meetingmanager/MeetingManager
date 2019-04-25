package com.meeting.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.meeting.pojo.Meeting;
import com.meeting.service.ImageService;
import com.meeting.service.ImageServiceImpl;

@Controller
@RequestMapping(value="picture")
public class ImageController {
	@Autowired
	ImageService imageService;
	
	/*
	 * 图片上传
	 * */
	@RequestMapping(value="upload",method=RequestMethod.POST)
	public Map upload(@RequestParam("pic1") MultipartFile pic1){
		
		Map resultMap = imageService.upload(pic1);
		return resultMap;
	}
	
	/*
	 * 图片下载
	 * */
	@RequestMapping(value="download")
	public void download(String url,HttpServletResponse response) throws IOException{
		
		File file = imageService.download(url);
		FileInputStream fis = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		int count;
		byte[] bs = new byte[1024];
		while((count = fis.read(bs))!= -1){
			os.write(bs, 0, count);
		}
		os.flush();
		fis.close();
		os.close();
	}
	
	/*
	 * 会议照片更新
	 * */
	@RequestMapping(value="meetingImage",method=RequestMethod.POST)
	public ModelAndView meetingImage(@RequestParam(value="pic1",required=false) MultipartFile pic1,HttpSession session){
		ModelAndView movi = new ModelAndView();
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		long mnum = meeting.getMnum();
		
		Map map = imageService.meetingImage(pic1, mnum);
		String imageURL = (String) map.get("url");
		movi.addObject("imageURL", imageURL);
		movi.setViewName("meetingImage");
		return movi;
	}
	
}
