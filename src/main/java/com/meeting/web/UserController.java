package com.meeting.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.code.kaptcha.Constants;
import com.meeting.pojo.User;
import com.meeting.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	UserService userService;
	
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
	
}
