package com.meeting.web;


import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meeting.pojo.Meeting;
import com.meeting.service.MeetingService;

/*
 * ±‚∆ΩªØ
 * */
@Controller
@RequestMapping("/Delayering")
public class DelayeringController {
	
	@Autowired 
	private MeetingService meetingService;
	@RequestMapping(value="Cockpit")
	public ModelAndView Cockpit(HttpSession session){
		ModelAndView movi = new ModelAndView();
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		meeting = meetingService.getMeetingById(meeting.getMnum());
		Date date = meeting.getMtime();
		 DateFormat df1 = DateFormat.getDateInstance();
		 System.out.println(df1.format(date));
		 DateFormat df3 = DateFormat.getTimeInstance();
		 System.out.println(df3.format(date));
		 movi.addObject("date", df1.format(date));
		 movi.addObject("time", df3.format(date));
		 movi.setViewName("Cockpit");
		return movi;
	}
}
