package com.meeting.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meeting.pojo.Meeting;
import com.meeting.service.MeetingService;


@Controller
public class MeetingController {

	@Autowired
	MeetingService meetingService;
	
	@RequestMapping("/meeting/{mnum}")
	@ResponseBody
	public Meeting getMeetingById(@PathVariable long mnum){
		Meeting meeting = meetingService.getMeetingById(mnum);
		return meeting;
	}
}
