package com.meeting.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthToggleButtonUI;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.meeting.pojo.Eattype;
import com.meeting.pojo.ExpandedEat;
import com.meeting.pojo.Meeting;
import com.meeting.pojo.UserEat;
import com.meeting.service.EatService;

import net.sf.json.JSONArray;


@Controller
@RequestMapping("/eattype")
public class EatController {

	@Autowired
	EatService eatService;
	
	/*
	 *根据会议号查询住宿情况
	 * 
	 * */
	@RequestMapping(value="selectEat",method=RequestMethod.POST)
	@ResponseBody
	public List<Eattype> selectEat(HttpSession session){
		List<Eattype> list = new ArrayList<Eattype>();
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		list = eatService.selectEat(meeting.getMnum());
		
		return list;
	}
	
	/*
	 * 插入一条用餐记录
	 * */
	@RequestMapping(value="insert",method=RequestMethod.POST,consumes="application/json;charset=utf-8")
	public void insertEat(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @RequestBody Eattype eattype,
				HttpSession session,HttpServletResponse response) throws ParseException, IOException{
		
		/*
		 * 修改时间格式
		 * */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//开始时间
		long starttime = eattype.getEttimestart().getTime();
		//System.out.println(starttime);
		String dString = format.format(starttime);
		eattype.setEttimestart(format.parse(dString));
		//结束时间
		long endtime = eattype.getEttimeend().getTime();
		String eString = format.format(endtime);
		eattype.setEttimeend(format.parse(eString));
		
		/*
		 * 获取会议号
		 * */
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		eattype.setMnum(meeting.getMnum());
		
		eatService.insertEat(eattype);
		
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
	 * 更新一个用餐信息
	 * */
	@RequestMapping(value="update",consumes="application/json;charset=utf-8")
	public void updateEat(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") @RequestBody Eattype eattype,
				HttpServletResponse response) throws ParseException, IOException{
		
		
		/*
		 * 根据etnum获取用餐类型号
		 * */
		Eattype eattype2 = eatService.selectByPrimaryKey(eattype.getEtnum());
		
		
		/*
		 * 修改时间格式
		 * */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//开始时间
		long starttime = eattype.getEttimestart().getTime();
		String dString = format.format(starttime);
		System.out.println(dString);
		eattype2.setEttimestart(format.parse(dString));
		
		//结束时间
		long endtime = eattype.getEttimeend().getTime();
		String eString = format.format(endtime);
		System.out.println(eString);
		eattype2.setEttimeend(format.parse(eString));
		
		//更新会议地点
		eattype2.setEtplace(eattype.getEtplace());
		//更新会议类型
		eattype2.setEttype(eattype.getEttype());
		System.out.println("---------------");
		System.out.println(eattype2.getEttimestart());
		System.out.println(eattype2.getEttimeend());
		eatService.updateEat(eattype2);
		
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
	 * 根据主键删除用餐记录
	 * */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public void deleteEat(int etnum,HttpServletResponse response) throws IOException{
		
		eatService.deleteEat(etnum);
		//设置将字符已"UTF-8"编码输出到客户端浏览器
		response.setCharacterEncoding("UTF-8");
		//获取PrintWriter输出流
		PrintWriter out = response.getWriter();
		out.write("{\"status\":1}");
  		//刷新缓存，能够让接受者更快接收
  		out.flush();
  		return;
	}
	
	@RequestMapping(value="jumpPage",method=RequestMethod.POST)
	@ResponseBody
	public void jumpPage(int etnum){
		
		System.out.println(etnum);
	}
	
	
	@RequestMapping(value="selectEatParticipants",method=RequestMethod.GET)
	public ModelAndView selectEatParticipants(int etnum,HttpSession session){
		ModelAndView movi = new ModelAndView();
		/*
		 * 获取会议号
		 * */
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("etnum", (long) etnum);
		map.put("mnum", meeting.getMnum());
		List<ExpandedEat> list = eatService.selectEatParticipants(map);
		JSONArray listArray = JSONArray.fromObject(list);
		movi.addObject("list", listArray);
		movi.addObject("etnum", etnum);
		movi.setViewName("selectEatParticipants");
		return movi;
	}
	
	@RequestMapping(value="insertEat",method=RequestMethod.POST)
	public void insertEat(@RequestParam(value="res[]",required=false) int[] res,int etnum,
			HttpSession session,HttpServletResponse response) throws IOException{
		System.out.println(res[0]);
		/*
		 * 获取会议号
		 * */
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		eatService.insertEatAarray(res, etnum, meeting.getMnum());
		
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
	 * 请求获取用户信息
	 * */
	@RequestMapping(value="selectUser",method=RequestMethod.POST)
	@ResponseBody
	public List<UserEat> selectUser(int etnum,HttpSession session){
		
		/*
		 * 获取会议号
		 * */
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("mnum", meeting.getMnum());
		map.put("etnum", (long) etnum);
		List<UserEat> list = eatService.selectUserByMnumEtnum(map);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		return list;
		
	}
	
	
	/*
	 * 根据eatnum删除记录
	 * */
	@RequestMapping(value="deleteEat",method=RequestMethod.POST)
	public void deleteSpecificEat(Integer eatnum,HttpServletResponse response) throws IOException{
		
		eatService.deleteSpecificEat(eatnum);
		
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
