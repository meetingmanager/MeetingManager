package com.meeting.service;

import java.util.Map;
import java.io.File;
import org.springframework.web.multipart.MultipartFile;

/*
 * 照片的上传和下载
 * */
public interface ImageService {
	
	//图片上传
	public Map upload(MultipartFile file);
	//图片下载
	public File download(String filename);
	
	//会议照片上传
	public Map meetingImage(MultipartFile file,long mnum);
}
