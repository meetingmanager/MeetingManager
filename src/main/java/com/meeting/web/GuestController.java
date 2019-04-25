package com.meeting.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meeting.pojo.Guest;
import com.meeting.pojo.Meeting;
import com.meeting.service.GuestService;

@Controller
@RequestMapping("/guest")
public class GuestController {
	
	
	@Autowired
	GuestService guestService;
	@RequestMapping(value="show")
	public String showGuest(){
		return "invite";
	}
	
	/*
	 * 添加嘉宾
	 * */
	@RequestMapping(value="add")
	public void addGuest(@RequestParam("aN")String[] aN,@RequestParam("aP")String[] aP,
							@RequestParam("aT")String[] aT,@RequestParam("aI")String[] aI,
							HttpSession session){
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		long mnum = meeting.getMnum();
		guestService.addGuest(mnum, aN, aP, aT, aI);
	}
	
	@RequestMapping(value="selectGuest",method=RequestMethod.POST)
	@ResponseBody
	public List<Guest> selectGuest(HttpSession session){
		List<Guest> list = new ArrayList<Guest>();
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		list = guestService.getGuest(meeting.getMnum());
		return list;
	}
	@RequestMapping(value="insert",method=RequestMethod.POST)
	public void insertGuest(@RequestBody Guest guest,HttpSession session,HttpServletResponse response) throws IOException{
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		guest.setMnum(meeting.getMnum());
		guestService.insertGuest(guest);
		
		//设置将字符已"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("UTF-8");
		//获取PrintWriter输出流
		PrintWriter out = response.getWriter();
		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();
  		return;
	}
	@RequestMapping(value="updateState",method=RequestMethod.POST)
	public void updateState(String gstate,int gnum,String greason,HttpServletResponse response) throws IOException{
		Guest guest = guestService.getGuestById(gnum);
		guest.setGstate(gstate);
		guest.setGreason(greason);
		guestService.updateGuest(guest);
		
		//设置将字符已"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("UTF-8");
		//获取PrintWriter输出流
		PrintWriter out = response.getWriter();
		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();
  		return;
	}
	
	@RequestMapping(value="update",method=RequestMethod.POST)
	public void updateGuest(@RequestBody Guest originalGuest,HttpServletResponse response) throws IOException{
		
		Guest guest = guestService.getGuestById(originalGuest.getGnum());
		guest.setGname(originalGuest.getGname());
		guest.setGphone(originalGuest.getGphone());
		guest.setGtitle(originalGuest.getGtitle());
		guest.setGintroduction(originalGuest.getGintroduction());
		guestService.updateGuest(guest);
		
		//设置将字符已"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("UTF-8");
		//获取PrintWriter输出流
		PrintWriter out = response.getWriter();
		out.write("{\"status\":1}");
		//刷新缓存，能够让接受者更快接收
		out.flush();
		return;
	}
	
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public void deleteGuest(int gnum,HttpServletResponse response) throws IOException{
		guestService.deleteGuest(gnum);
		
		//设置将字符已"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("UTF-8");
		//获取PrintWriter输出流
		PrintWriter out = response.getWriter();
		out.write("{\"status\":1}");
		//刷新缓存，能够让接受者更快接收
		out.flush();
		return;
	}
}
