package com.meeting.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.meeting.common.GuestNameAndGtitle;
import com.meeting.common.MeetingView;
import com.meeting.common.UserNameImage;
import com.meeting.pojo.Eattype;
import com.meeting.pojo.Guest;
import com.meeting.pojo.Hoteltype;
import com.meeting.pojo.Meeting;
import com.meeting.pojo.User;
import com.meeting.service.EatService;
import com.meeting.service.GuestService;
import com.meeting.service.HotelService;
import com.meeting.service.MeetingService;
import com.meeting.service.ParticipantsService;
import com.meeting.service.SeatService;
import com.meeting.service.UserService;



@Controller
@RequestMapping("/meeting")
public class MeetingController {

	@Autowired
	MeetingService meetingService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	GuestService guestService;
	
	@Autowired
	ParticipantsService participantsService;
	@Autowired
	SeatService seatService;
	@Autowired
	EatService eatService;
	
	@Autowired
	HotelService hotelService;
	@RequestMapping("{mnum}")
	@ResponseBody
	public Meeting getMeetingById(@PathVariable long mnum){
		Meeting meeting = meetingService.getMeetingById(mnum);
		return meeting;
	}

	@RequestMapping(value="add",method = RequestMethod.POST)
	public void addMeeting(HttpServletRequest request,
							HttpServletResponse response) throws IOException, ParseException{
		
		//获取当前用户
		//获取cookie数组
		Cookie[] cookies = request.getCookies();
		String userid = null;
		for(Cookie c:cookies){
			if(c.getName().equals("userid")){
				userid = c.getValue();
			}
		}
		
		String mname = request.getParameter("mname");
		String mplace = request.getParameter("mplace");
		String mtime = request.getParameter("mtime");
		String mguide = request.getParameter("mguide");
		String mflow = request.getParameter("mflow");
		String mcontent = request.getParameter("mcontent");
		Meeting meeting = new Meeting();
		//获取会议时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		meeting.setMtime(sdf.parse(mtime));
		meeting.setMname(mname);
		meeting.setMplace(mplace);
		meeting.setMguide(mguide);
		meeting.setMflow(mflow);
		meeting.setMcontent(mcontent);
		meeting.setUserid(userid);
		meetingService.createMeeting(meeting);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		//获去PrintWriter输入流
		PrintWriter out = response.getWriter();
		//创建会议成功
  		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();
		
		/*//设置字符以"UTF-8"的方式返回到浏览器
		response.setCharacterEncoding("UTF-8");
		//获去PrintWriter输入流
		PrintWriter out = response.getWriter();
		
		
		meetingService.createMeeting(meeting);
		
		//创建会议成功
  		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();*/
	}
	
	/*
	 * 
	 * */
	@RequestMapping(value="find",method = RequestMethod.POST)
	@ResponseBody
	public List<MeetingView> findMeetingView(String userid){
		List<MeetingView> meetingViews =new ArrayList<MeetingView>();
		List<Meeting> list = meetingService.findMeetingView(userid);
		String urlPic = "meetingPic.jpg";
		for(int i=0;i<list.size();i++){
			Meeting meeting = list.get(i);
			MeetingView meetingView = new MeetingView();
			meetingView.setMflag(meeting.getMflag());
			meetingView.setMname(meeting.getMname());
			meetingView.setMtime(meeting.getMtime());
			meetingView.setMnum(meeting.getMnum());
			if(meeting.getMimage() == null || meeting.getMimage().isEmpty()){
				meetingView.setUrl(urlPic);
			}else{
				meetingView.setUrl(meeting.getMimage());
			}
			
			meetingViews.add(meetingView);
		}
		
		/*
		 * 获取当前用户参加的会议
		 * */
		User user = userService.findUserById(userid);
		String joinMeeting = user.getUserseat();
		System.out.println(joinMeeting.length());
		JSONObject json = new JSONObject();
		if(joinMeeting.length() > 0){
			json = JSONObject.parseObject(joinMeeting);
			for (Map.Entry<String,Object> entry : json.entrySet()) {
				if(entry.getValue().equals(1)){
					Meeting meeting = meetingService.getMeetingById(Integer.valueOf(entry.getKey()).intValue());
					MeetingView meetingView = new MeetingView();
					//参加的会议的flag为2，自己创建的为1
					meetingView.setMflag(2);
					meetingView.setMname(meeting.getMname());
					meetingView.setMtime(meeting.getMtime());
					meetingView.setMnum(meeting.getMnum());
					if(meeting.getMimage() == null || meeting.getMimage().isEmpty()){
						meetingView.setUrl(urlPic);
					}else{
						meetingView.setUrl(meeting.getMimage());
					}
					meetingViews.add(meetingView);
				}
			}
		}
		return meetingViews;
	}
	
	@RequestMapping(value="select",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView findMeetingById(int mflag,long mnum,HttpSession session,HttpServletRequest request){
		
		ModelAndView movi = new ModelAndView();
		Meeting meeting = meetingService.findMeetingById(mnum);
		session.setAttribute("meeting", meeting);
		
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
		 * 进入该用户创建的会议中
		 * */
		if(mflag == 1){
			//获取用户信息和用户头像
			UserNameImage ni = new UserNameImage();
			//根据userid获取用户信息
			User user = userService.findUserById(userid);
			if(user.getHeadphoto().isEmpty()){
				user.setHeadphoto("headphoto.png");
			}
			ni.setHeadphoto(user.getHeadphoto());
			ni.setUserid(user.getUserid());
			movi.setViewName("adminMain");
			movi.addObject("meeting", meeting);
			movi.addObject("ni", ni);
		}
		/*
		 * 进入该用户加入的会议中
		 * */
		if(mflag == 2){
			//获取该会议的参会嘉宾
			List<Guest> guests = guestService.getGuest(mnum);
			//创建一个对象，只存放嘉宾的名字和职称
			List guestList = new ArrayList<GuestNameAndGtitle>();
			for (Guest guest : guests) {
				GuestNameAndGtitle gnt = new GuestNameAndGtitle();
				gnt.setGuestName(guest.getGname());
				System.out.println(guest.getGname());
				gnt.setGuestTitle(guest.getGtitle());
				guestList.add(gnt);
			}
			JSONArray jsonArray = (JSONArray) JSONArray.toJSON(guestList);
			//获取会议的座位信息:seatnum
			int pnum = participantsService.selectPnumByMnumAndUserid(meeting.getMnum(), userid);
			//int seatnum = seatService.selectSeatInUserid(meeting.getMnum(), pnum);
			//String seat;
			
			
			//获取该用户参加本次会议的分配的用餐情况
			Map<String, Long> map = new HashMap<String, Long>();
			map.put("mnum", meeting.getMnum());
			map.put("pnum", (long) pnum);
			List<Eattype> eattypes = eatService.selectEattypeByPM(map);
			
			//获取该用户参加本次会议的分配的住宿情况
			Map<String, Long> mapHotel = new HashMap<String, Long>();
			mapHotel.put("mnum", meeting.getMnum());
			mapHotel.put("pnum", (long) pnum);
			List<Hoteltype> hoteltypes = hotelService.seleteHoteltypeByUserid(mapHotel);
			
			JSONArray eattypesArray = (JSONArray) JSONArray.toJSON(eattypes);
			//System.out.println(eattypes.get(0).getEttimestart());
			
			JSONArray hoteltypesArray = (JSONArray) JSONArray.toJSON(hoteltypes);
			movi.addObject("meeting", meeting);
			movi.addObject("guestList", jsonArray);
			//movi.addObject("seatnum", seatnum);
			movi.addObject("eat", eattypesArray);
			movi.addObject("hotel", hoteltypesArray);
			movi.setViewName("userShow");
		}
		
		return movi;
		
		/*Meeting meeting = meetingService.findMeetingById(mnum);
		return meeting;*/
	}
	
	/*
	 * 更新会议信息
	 * */
	@RequestMapping(value="update")
	public ModelAndView updateMnameByMnum(Meeting meeting){
		ModelAndView movi = new ModelAndView();
		
		meetingService.updateMeeting(meeting);
		movi.setViewName("updateMeeting");
		Meeting meeting2 = meetingService.findMeetingById(meeting.getMnum());
		movi.addObject("meeting",meeting2);
		return movi;
		
	}
	
	/*
	 * 获取会议照片
	 * */
	@RequestMapping(value="meetingImage")
	public ModelAndView meetingImage(HttpSession session){
		ModelAndView movi = new ModelAndView();
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		Meeting meeting2 = meetingService.findMeetingById(meeting.getMnum());
		if(meeting2.getMimage() == null || meeting2.getMimage().isEmpty()){
			meeting2.setMimage("meetingPic.jpg");
		}
		System.out.println(meeting2.getMimage());
		movi.addObject("imageURL", meeting2.getMimage());
		movi.setViewName("meetingImage");
 		return movi;
	}
	
	/*
	 * 结束会议
	 * */
	@RequestMapping(value="closeMeeting")
	public void closeMeeting(HttpSession session,HttpServletResponse response) throws IOException{
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		Meeting meeting2 = meetingService.findMeetingById(meeting.getMnum());
		//修改会议状态码mflag = 0
		meeting2.setMflag(0);
		meetingService.updateMeetingById(meeting2);
		//设置字符以"UTF-8"的方式返回到浏览器
		response.setCharacterEncoding("UTF-8");
		//获去PrintWriter输入流
		PrintWriter out = response.getWriter();
		
		
		//创建会议成功
  		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();
	}
	
	@RequestMapping(value="seleteMeetingByName",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> seleteMeetingByName(String name,HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		System.out.println(name);
		if(!name.isEmpty()){
		//使用cookie获取用户名
		String userid = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("userid")){
				userid = cookie.getValue();
				break;
			}
		}
		List<Meeting> list = new ArrayList<Meeting>();
		
		//获取用户创建的会议
		list = meetingService.selectMeetingByName(name, userid,0);
		User user = userService.findUserById(userid);
		//获取用户加入的会议
		String joinMeeting = user.getUserseat();
		JSONObject json = new JSONObject();
		json = JSONObject.parseObject(joinMeeting);
		for (Entry<String, Object> entry : json.entrySet()) {
			List<Meeting> list1 = meetingService.selectMeetingByName(name, userid, Long.parseLong(entry.getKey()));
			for (int i = 0; i < list1.size(); i++) {
				list1.get(i).setMflag(2);
			}
			list.addAll(list1);
		}
		Map<String, String> map =new HashMap<String,String>();
		if(!list.isEmpty()){
			//将会议号返回成字符串
			long[] mnums = new long[list.size()*2];
			for (int i = 0; i < list.size(); i++) {
				mnums[i*2] = list.get(i).getMnum();
				mnums[i*2+1] = list.get(i).getMflag();
			}
			map.put("status", "1");
			map.put("mnums", StringUtils.join(mnums, ','));
		}else{
			map.put("status", "2");
		}
		return map;
	}else{
		Map<String, String> map =new HashMap<String,String>();
		map.put("status", "2");
		return map;
	}
	}
	
	@RequestMapping(value="selectHomePage",method = RequestMethod.GET)
	public ModelAndView selectHomePage(String mnums){
		ModelAndView movi = new ModelAndView();
		String[] mnumString = mnums.split(",");
		List<Meeting> list = new ArrayList<Meeting>();
		String urlPic = "meetingPic.jpg";
		int i=0;
		while(i<mnumString.length){
			
			Meeting meeting = meetingService.findMeetingById(Long.parseLong(mnumString[i]));
			if(meeting.getMimage() == null || meeting.getMimage().isEmpty()){
				meeting.setMimage(urlPic);
			}
			if(mnumString[i+1].equals("2")){
				meeting.setMflag(2);
			}
			list.add(meeting);
			if(i==0){
				i = (i+1)*2;
				
			}else{
				i = i*2;
			}
		}
		JSONArray hoteltypesArray = (JSONArray) JSONArray.toJSON(list);
		movi.addObject("list", hoteltypesArray);
		movi.setViewName("selectHomePage");
		return movi;
	}
	@RequestMapping(value="copyMnum")
	public ModelAndView copyMnum(HttpSession session){
		ModelAndView movi = new ModelAndView();
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		movi.addObject("mnum", meeting.getMnum());
		movi.setViewName("copyMnum");
		return movi;
	}
}
