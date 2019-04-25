package com.meeting.web;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.meeting.pojo.ExpandedEat;
import com.meeting.pojo.Meeting;
import com.mysql.fabric.xmlrpc.base.Array;


@Controller
@RequestMapping("/html")
public class HomePageController {
	
	@RequestMapping(value="homepage")
	public String toHomepage(){
		return "homepage";
	}
	
	
	@RequestMapping(value="index")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping(value="buildone")
	public String toBuildOne(){
		return "build-one";
	}
	
	@RequestMapping(value="test")
	public String toTest(){
		return "test";
	}
	
	
	@RequestMapping(value="left")
	public String toLeft(){
		
		return "left";
	}
	
	@RequestMapping(value="title")
	public String toTitle(){
		return "title";
	}
	
	@RequestMapping(value="updateMeeting")
	@ResponseBody
	public ModelAndView toView(HttpSession session){
		ModelAndView movi = new ModelAndView();
		movi.setViewName("updateMeeting");
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		movi.addObject("meeting", meeting);
		return movi;
	}
	
	@RequestMapping(value="joinMeeting")
	public String toJoinMeeting(){
		return "joinMeeting";
	}
	
	@RequestMapping(value="zhuce")
	public String tozhuce(){
		return "zhuce";
	}
	
	@RequestMapping(value="userShow")
	public String touserShow(){
		return "userShow";
	}
	
	@RequestMapping(value="hotel")
	public String tohotel(){
		return "hotel";
	}
	
	@RequestMapping(value="eat")
	public String toEat(){
		return "eat";
	}
	
	
}
