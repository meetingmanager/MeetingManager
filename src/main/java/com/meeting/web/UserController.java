package com.meeting.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;
import com.meeting.pojo.User;
import com.meeting.service.ImageService;
import com.meeting.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ImageService imageService;
	/**
	 * 验证码验证
	 */
	public boolean VerifyCodeUtil(HttpServletRequest request){
		String code=request.getParameter("authCode"); 
		String original =(String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (!StringUtils.isEmpty(code)) {
            if (code.equalsIgnoreCase(original)) {
            	return true;
            }
        }
		return false;
	}
	
	/*
	 * 登录
	 * */
	@RequestMapping(value="login",method = RequestMethod.POST)
	public void login(User user,HttpServletRequest request,
    		HttpServletResponse response) throws IOException{
		
		//设置将字符已"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("UTF-8");
		//获取PrintWriter输出流
		PrintWriter out = response.getWriter();
		//验证码验证
		
		//检验用户名
		User userDb = userService.findUserById(user.getUserid());
		if( userDb == null ){
			out.write("{\"status\":0}");//用户不存在
			return;
		}
		//检验用户密码
		if( !userDb.getUserpw().equals(user.getUserpw())){
			out.write("{\"status\":-1}");//密码错误
			return;
		}
		//这里不使用shiro认证，所以完成登录，保存用户信息到回话范围
        request.getSession().setAttribute("user", user);
        //获取WEB服务器的IP地址
  		System.out.println(request.getLocalAddr());
  		//获取WEB服务器的主机名
  		System.out.println(request.getLocalName());
  		//session.setAttribute("userDb", userDb);
  		//创建用户名cookie
  		Cookie useridCookie = new Cookie("userid", user.getUserid());
  		//设置有效时间3天
  		useridCookie.setMaxAge(60*60*24*3);
  		//useridCookie.setMaxAge(60);
  		useridCookie.setPath("/");
  		response.addCookie(useridCookie);
  		
  		//创建密码cookie
  		Cookie passwdCookie = new Cookie("userpw", user.getUserpw());
  		//设置有效时间30分钟
  		passwdCookie.setMaxAge(60*60*24*3);
  		//useridCookie.setMaxAge(60);
  		passwdCookie.setPath("/");
  		response.addCookie(passwdCookie);
  		
  		//登录成功
  		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();
  		return;
	}
	
	/*
	 * 后台注册
	 * */
	@RequestMapping(value="add",method = RequestMethod.POST)
	public void add(User user,HttpServletRequest request,
    		HttpServletResponse response) throws IOException{
		//设置将字符已"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("UTF-8");
		//获取PrintWriter输出流
		PrintWriter out = response.getWriter();
		//验证码验证
		boolean checkCode = VerifyCodeUtil(request);
		if(!checkCode){
			out.write("{\"status\":2}");
		}
		//判断用户名是否被注册
		User userDbByID = userService.findUserById(user.getUserid());
		if(userDbByID != null && userDbByID.getUserid() == user.getUserid()){
			out.write("{\"status\":3}");
		}
		
		//判断手机号码是否被注册
		User userDbByPhone = userService.findUserByPhone(user.getPhone()); 
		if(userDbByPhone != null && userDbByPhone.getPhone() == user.getPhone()){
			out.write("{\"status\":4}");
		}
		userService.InsertUser(user);
		//获取WEB服务器的IP地址
		System.out.println(request.getLocalAddr());
		//获取WEB服务器的主机名
		System.out.println(request.getLocalName());
		//插入成功返回
		out.write("{\"status\":1}");
		
	}
	
	/*
	 * 退出登录
	 * */
	@RequestMapping(value="cancel",method=RequestMethod.POST)
	public void cancel(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//获得cookie数组
		Cookie[] cookies = request.getCookies();
		//遍历cookie数组，获取用户名和密码
		String userid = null;
		String userpw = null;
		for(Cookie c:cookies){
			if(c.getName().equals("userid")){
				userid = c.getValue();
			}
			if(c.getName().equals("userpw")){
				userpw = c.getValue();
			}
	}
		//创建用户名cookie
  		Cookie useridCookie = new Cookie("userid", userid);
  		useridCookie.setMaxAge(0);
  		useridCookie.setPath("/");
  		response.addCookie(useridCookie);
  		
  		//创建密码cookie
  		Cookie passwdCookie = new Cookie("userpw", userpw);
  		passwdCookie.setMaxAge(0);
  		passwdCookie.setPath("/");
  		response.addCookie(passwdCookie);
  		
  		out.write("{\"status\":1}");
  		out.flush();
  		
	}
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String changeToIndex(){
		return "index";
	}
	
	/*
	 * 获取用户信息
	 * */
	@RequestMapping(value="find")
	public ModelAndView findUser(HttpServletRequest request,HttpServletResponse response){
		ModelAndView movi = new ModelAndView();
		
		//使用cookie获取用户名
		String userid = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("userid")){
				userid = cookie.getValue();
				break;
			}
		}
		
		//根据userid获取用户信息
		User user = userService.findUserById(userid);
		
		//判断用户头像是否为空，若空，则发送默认照片
		if(user.getHeadphoto() == null){
			user.setHeadphoto("headphoto.png");
		}
		movi.addObject("user", user);
		movi.setViewName("UserInfo"); 
		return movi;
	}
	
	@RequestMapping(value="UpdateUserInfo",method=RequestMethod.POST)
	public ModelAndView UpdateUserInfo(@RequestParam(value="pic1",required=false) MultipartFile pic1,User user,
			HttpServletRequest request){
		ModelAndView movi = new ModelAndView();
		
		//使用cookie获取用户名
		String userid = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("userid")){
				userid = cookie.getValue();
				break;
			}
		}
		/*
		 * 根据userid获取用户信息
		 * */
		User user2 = userService.findUserById(userid);
		
		/*
		 * 判断是否修改头像
		 * */
		if(!pic1.isEmpty()){
			Map map = imageService.upload(pic1);
			String url = (String) map.get("url");
			user2.setHeadphoto(url);
		}
		
		/*
		 * 修改其他用户信息
		 * */
		user2.setUsername(user.getUsername());
		user2.setEmail(user.getEmail());
		user2.setUsersex(user.getUsersex());
		user2.setPhone(user.getPhone());
		
		userService.updateUser(user2);
		
		User resultUser = userService.findUserById(user2.getUserid());
		movi.addObject("user", resultUser);
		movi.setViewName("homepage");
		return movi;
	}
	
}
