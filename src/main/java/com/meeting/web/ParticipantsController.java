package com.meeting.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.fmt.ParseNumberSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.meeting.common.MapAndString;
import com.meeting.common.ParticipantsList;
import com.meeting.pojo.Meeting;
import com.meeting.pojo.Participants;
import com.meeting.pojo.User;
import com.meeting.service.ParticipantsService;
import com.meeting.service.UserService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/participants")
public class ParticipantsController {
	
	@Autowired
	ParticipantsService participantsService;
	
	@Autowired
	UserService userService;
	/*
	 *根据mnum获取该会议的参会人员
	 * */
	@RequestMapping(value="/findByMnum")
	@ResponseBody
	public ModelAndView findParticipantsByMnum(HttpSession session){
		ModelAndView movi = new ModelAndView();
		List<Participants> list = new ArrayList<Participants>();
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		list = participantsService.findPartipantsByMnum(meeting.getMnum());
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.err.println(jsonArray.toString());
		for (Participants participants : list) {
			System.out.println(participants.toString());
		}
		
		movi.setViewName("audit");
		movi.addObject("list", jsonArray);
		return movi;
	}
	
	@RequestMapping(value="updateByPnum",method=RequestMethod.POST)
	public void updateParticipantsByPnum(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		String pnum = request.getParameter("pnum");
		String pflag = request.getParameter("pflag");
		int intPnum = Integer.parseInt(pnum);
		int intPflag = Integer.parseInt(pflag);
		System.out.println(pnum+ "::"+pflag);
		participantsService.updatePartipants(intPnum, intPflag);
		
		/*
		 * 将审批之后的状态码按照json数据串的格式存入到响应的用户中
		 * */
		
		//获取该用户名
		Participants participants = participantsService.findPartipantsByPnum(intPnum);
		//修改用户参会表
		User user = userService.findUserById(participants.getUserid());
		String seat = user.getUserseat();
		
		JSONObject json = new JSONObject();
		if(seat == null || seat.isEmpty()){
			json.put(participants.getMnum().toString(),intPflag);
		}
		else{
			json = JSONObject.parseObject(seat);
			json.put(participants.getMnum().toString(),intPflag);
		}
		//JSON->String
		seat = json.toJSONString();
		
		user.setUserseat(seat);
		userService.updateUser(user);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		//获去PrintWriter输入流
		PrintWriter out = response.getWriter();
		//创建会议成功
  		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();
	}
	
	/*
	 * 参会人员展示
	 * */
	@RequestMapping(value="find")
	public ModelAndView findParticipants(HttpSession session){
		ModelAndView movi = new ModelAndView();
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		List<Participants> list = participantsService.findPartpantsByMP(meeting.getMnum());
		
		List<ParticipantsList> participantsLists = new ArrayList<ParticipantsList>();
		for(int i=0;i<list.size();i++){
			ParticipantsList participantsList = new ParticipantsList();
			Participants participants = new Participants();
			participants = list.get(i);
			participantsList.setImage(userService.findUserById(participants.getUserid()).getHeadphoto());
			participantsList.setPflag(participants.getPflag());
			participantsList.setPname(participants.getPname());
			participantsList.setPsex(participants.getPsex());
			participantsList.setPphone(participants.getPphone());
			participantsLists.add(participantsList);
		}
		JSONArray jsonArray = JSONArray.fromObject(participantsLists);
		
		movi.setViewName("auditShow");
		movi.addObject("list", jsonArray);
		return movi;
	}
	
	/*
	 * 根据会议号，返回参会人员状态码为1（批准参会）和2（拒绝参会）
	 * */
	@RequestMapping(value="selectMP",method=RequestMethod.POST)
	public List<Participants> selectMP(HttpSession session){
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		List<Participants> list = participantsService.findPartpantsByMP(meeting.getMnum());
		return list;
	}
	
	/*
	 * 申请加入某个会
	 * */
	@RequestMapping(value="applyJoinMeeting")
	public ModelAndView applyJoinMeeting(long mnum,HttpServletRequest request){
		ModelAndView movi = new ModelAndView();
		/*
		 * 判断会议是否为当前用户创建的，若是，则不能申请加入
		 * 待开发
		 * */
		Participants participants = new Participants();
		
		//获取当前用户
		Cookie[] cookies = request.getCookies();
		String userid = null;
		for (Cookie c : cookies) {
			if(c.getName().equals("userid")){
				userid = c.getValue();
			}
		}
		
		/*
		 * 判断是否重复加入本次会议
		 * */
		int pnum = participantsService.selectPnumByMnumAndUserid(mnum, userid);
		User user = userService.findUserById(userid);
		if(pnum == 0){
			/*
			 * 判断该用户是否完善了名字和手机号码
			 * */
			if(user.getUsername() == null || user.getUsername() == "" || user.getPhone() == null || user.getPhone() == ""){
				String message = "亲爱的用户，你仍未设置您的名字和电话号码，请到用户信息管理完成用户信息";
				movi.addObject("message", message);
			}else{
				//完善参会人员信息
				participants.setUserid(user.getUserid());
				participants.setMnum(mnum);
				participants.setPname(user.getUsername());
				participants.setPsex(user.getUsersex());
				participants.setPphone(user.getPhone());
				participantsService.applyJoinMeeting(participants);
				String message = "亲爱的用户，感谢你申请加入本次会议，请耐心等待审批";
				movi.addObject("message", message);
			}
		}else{
			String message = "亲爱的用户，您已经申请加入本次会议，请耐心等待审批";
			movi.addObject("message", message);
		}

		//参会人员的单位
		//未开发
		
		movi.setViewName("joinMeeting");
		return movi;
	}
}
