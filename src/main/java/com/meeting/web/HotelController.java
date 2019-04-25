package com.meeting.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.meeting.mapper.HotelMapper;
import com.meeting.pojo.Eattype;
import com.meeting.pojo.ExpandedHotel;
import com.meeting.pojo.Hotel;
import com.meeting.pojo.Hoteltype;
import com.meeting.pojo.Meeting;
import com.meeting.pojo.UserEat;
import com.meeting.pojo.UserHotel;
import com.meeting.service.HotelService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	/*
	 * 根据会议号查询会议住宿情况
	 * */
	@RequestMapping(value="selectHotel")
	@ResponseBody
	public List<Hoteltype> selectHotel(HttpSession session){
		List<Hoteltype> list = new ArrayList<Hoteltype>();
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		list = hotelService.selectHotelByMnum(meeting.getMnum());
		return list;
	}
	
	/*
	 * 更新某会议的某用餐类型
	 * */
	@RequestMapping(value="updateHotel",consumes="application/json;charset=utf-8")
	public void updateHotel(@DateTimeFormat(pattern="yyyy-MM-dd") @RequestBody Hoteltype hoteltype,
			HttpServletResponse response) throws ParseException, IOException{
		
		/*
		 * 根据主键获取用餐类型
		 * */
		Hoteltype hoteltype2 = hotelService.selectHotelByPrimaryKey(hoteltype.getHtnum());
		
		/*
		 * 修改时间格式
		 * */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//开始时间
		long starttime = hoteltype.getStarttime().getTime();
		String dString = format.format(starttime);
		System.out.println(dString);
		hoteltype2.setStarttime(format.parse(dString));
		
		//结束时间
		long endtime = hoteltype.getEndtime().getTime();
		String eString = format.format(endtime);
		System.out.println(eString);
		hoteltype2.setEndtime(format.parse(eString));
		
		//更新住宿地点和住宿类型
		hoteltype2.setHotelplace(hoteltype.getHotelplace());
		hoteltype2.setHoteltype(hoteltype.getHoteltype());
		
		hotelService.updateHotel(hoteltype2);
		//设置将字符已"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("UTF-8");
		//获取PrintWriter输出流
		PrintWriter out = response.getWriter();
		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();
  		return;
	}
	/*
	 * 插入用餐类型
	 * */
	@RequestMapping(value="insertHotel",method=RequestMethod.POST,consumes="application/json;charset=utf-8")
	public void insertHotel(@DateTimeFormat(pattern="yyyy-MM-dd") @RequestBody Hoteltype hoteltype,
				HttpSession session,HttpServletResponse response) throws ParseException, IOException{
		
		//获取会议号
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		hoteltype.setMnum(meeting.getMnum());
		/*
		 * 修改时间格式
		 * */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//修改开始时间
		long starttime = hoteltype.getStarttime().getTime();
		String dString = format.format(starttime);
		hoteltype.setStarttime(format.parse(dString));
		
		//修改结束时间
		long endtime = hoteltype.getEndtime().getTime();
		String eString = format.format(endtime);
		hoteltype.setEndtime(format.parse(eString));
		
		hotelService.insertHotel(hoteltype);
		
		//设置将字符已"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("UTF-8");
		//获取PrintWriter输出流
		PrintWriter out = response.getWriter();
		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();
  		return;
		
	}
	
	/*
	 * 删除用餐类型
	 * */
	@RequestMapping(value="deleteHotel",method=RequestMethod.POST)
	public void deleteHotel(int htnum,HttpServletResponse response) throws IOException{
		
		hotelService.deleteHotel(htnum);
		//设置将字符已"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("UTF-8");
		//获取PrintWriter输出流
		PrintWriter out = response.getWriter();
		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();
  		return;
	}
	
	/*
	 * 跳转至某住宿类型
	 * */
	@RequestMapping(value="jumpPage",method=RequestMethod.POST)
	@ResponseBody
	public void jumpPage(int htnum){
		System.out.println(htnum);
	}
	
	/*
	 * 参会人员住宿选择
	 * */
	@RequestMapping(value="selectHotelParticipants",method=RequestMethod.GET)
	public ModelAndView selectHotelParticipants(int htnum,HttpSession session){
		ModelAndView movi = new ModelAndView();
		
		//获取会议号
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		
		//创建Map
		Map<String, Long> map = new HashMap<String,Long>();
		map.put("mnum", meeting.getMnum());
		map.put("htnum", (long) htnum);
		List<ExpandedHotel> list = hotelService.selectHotelParticipants(map);
		for (ExpandedHotel expandedHotel : list) {
			System.out.println(expandedHotel.toString());
		}
		JSONArray listArray = JSONArray.fromObject(list);
		movi.addObject("list", listArray);
		movi.addObject("htnum", htnum);
		movi.setViewName("selectHotelParticipants");
		return movi;
	}
	
	/*
	 * 某住宿类型分配的住宿人员信息
	 * */
	@RequestMapping(value="selectUser",method=RequestMethod.POST)
	@ResponseBody
	public List<UserHotel> selectUser(int htnum,HttpSession session){
		
		/*
		 * 获取会议号
		 * */
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("mnum", meeting.getMnum());
		map.put("htnum", (long) htnum);
		List<UserHotel> list = hotelService.selectUserByHotel(map);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		return list;
	}
	
	/*
	 * 插入用餐人员
	 * */
	@RequestMapping(value="insertHotelTab",method=RequestMethod.POST)
	public void insertHotelTab(@RequestParam(value="res[]",required=false) int[] res,int htnum,
			HttpSession session,HttpServletResponse response) throws IOException{
		
		/*
		 * 获取会议号
		 * */
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		
		for (int i = 0; i < res.length; i++) {
			
			Hotel hotel = new Hotel();
			hotel.setPnum(res[i]);
			hotel.setHtnum(htnum);
			hotel.setMnum(meeting.getMnum());
			hotelService.insertHotel(hotel);
		}
		
		//设置将字符已"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("UTF-8");
		//获取PrintWriter输出流
		PrintWriter out = response.getWriter();
		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();
  		return;
	}
	
	/*
	 * 删除用餐类型
	 * */
	@RequestMapping(value="deleteHotelTab",method=RequestMethod.POST)
	public void deleteHotelTab(int hnum,HttpServletResponse response) throws IOException{
		
		hotelService.deleteHotelTab(hnum);
		
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
