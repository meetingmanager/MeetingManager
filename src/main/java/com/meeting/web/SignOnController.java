package com.meeting.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.meeting.common.ParticipantsList;
import com.meeting.mapper.ExpandedSignonMapper;
import com.meeting.pojo.ExpandedSignon;
import com.meeting.pojo.Meeting;
import com.meeting.pojo.MyPageInfo;
import com.meeting.pojo.Participants;
import com.meeting.pojo.Signon;
import com.meeting.service.SignOnService;
import com.mysql.fabric.xmlrpc.base.Array;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("SignOn")
public class SignOnController {
	
	@Autowired
	private SignOnService signOnService;
	/*
	 * 会议签到
	 * */
	@RequestMapping(value="update",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> SignOnMeeting(HttpServletRequest request,HttpSession session){
		
		Map<String, String> map = new HashMap<String, String>();
		
		Signon signon = new Signon();
		
		//获取当前用户
		//获取cookie数组
		Cookie[] cookies = request.getCookies();
		String userid = null;
		for(Cookie c:cookies){
			if(c.getName().equals("userid")){
				userid = c.getValue();
			}
		}
		
		//获取会议号
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		
		signon.setUserid(userid);
		signon.setMnum(meeting.getMnum());
		
		map = signOnService.SignOnMeeting(signon);
		return map;
	}
	
	@RequestMapping(value="find")
	@ResponseBody
	public ModelAndView findSignOn(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession session){
		ModelAndView modelAndView = new ModelAndView();
		MyPageInfo myPageInfo = new MyPageInfo();
		myPageInfo.setHasNextPage(false);
		myPageInfo.setHasPreviousPage(false);
		myPageInfo.setPageNum(pn);
		if (pn != 1) {
			//有上一页
			myPageInfo.setHasPreviousPage(true);
		}
		//获取会议号
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		//每页限制6行
		int limit = 6;
		Map<String,Long> map = new HashMap<String,Long>();
		long mnum = meeting.getMnum();
		int signonNum = signOnService.SignOnCount(mnum);
		//将总数存进对象里
		myPageInfo.setTotal(signonNum);
		//计算总页数,存进去
		myPageInfo.setPages(signonNum / limit + 1);
		//根据总页数计算出页面快捷键的页码
		int navipagelength = 0;
		if (myPageInfo.getPages() - 5 > pn) {
			navipagelength = 5;
		}else{
			navipagelength = myPageInfo.getPages() - pn + 1;
		}
		int[] navipage = new int[navipagelength];
		int j = pn;
		for (int i = 0; i < navipage.length; i++) {
			navipage[i] = j++;
		}
		myPageInfo.setNavigatepageNums(navipage);
		
		long startNum = (pn - 1) * limit;
		long endNum = signonNum;
		
		if (signonNum > (pn * limit)) {
			endNum =  pn * limit;
			myPageInfo.setHasNextPage(true);
		}		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		map.put("mnum", mnum);
		List<ExpandedSignon> expandedSignons = signOnService.SignOnList(map);
		System.out.println("12313...."+expandedSignons.size());
		JSONArray jsonArray = JSONArray.fromObject(expandedSignons);
		JSONObject mypageinfo = (JSONObject) JSONObject.toJSON(myPageInfo);
		modelAndView.addObject("list",jsonArray);
		modelAndView.addObject("myPageInfo",mypageinfo);
		modelAndView.setViewName("SignOn");
		
		return modelAndView; 
	}
	@RequestMapping(value="excel",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> excelExport(HttpSession session) throws IOException{
		Map<String, String> map = new HashMap<String, String>();
		String fileDir = "C:/Users/XHJ/Desktop";
		String filePath = fileDir + "/" + "会议签到表"+ ".xls";
		if (!new File(fileDir).exists()) {
			new File(filePath).mkdirs();
		}
		File excel = new File(filePath);
		int i = 1;
		while(excel.exists()){
			int tmppath = filePath.lastIndexOf(".");
			if (i!=1) {
				tmppath= filePath.indexOf("(");
			}
			filePath = filePath.substring(0, tmppath) +"("+ (i++)+").xls";
			excel = new File(filePath);
		}
		excel.createNewFile();
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		
        String resultcount = excelExportFromDB(excel,meeting);
        
        map.put("path",filePath);
        map.put("resultcount",resultcount);
		
		return map;
	}

	private String excelExportFromDB(File excel,Meeting meeting) {
		// TODO Auto-generated method stub
		 int count =0;
	        try {
	        
	            //初始化定义一个workbook
	            WritableWorkbook writableWorkbook = null;
	            //创建可写入excel的工作簿
//	            File file = new File(fileName);
	            if (!excel.exists()) {
	                excel.createNewFile();
	            }
	            //以filename为文件名创建一个workbook
	            writableWorkbook = Workbook.createWorkbook(excel);
	            //创建工作表
	            WritableSheet writableSheet = writableWorkbook.createSheet("Sheet1", 0);

	            //查询数据库获取学生借用学院物品情况情况表中所有数据
	            int countSignon = signOnService.SignOnCount(meeting.getMnum());
	            Map<String, Long> map = new HashMap<String, Long>();
	            map.put("startNum", (long) 0);
	    		map.put("endNum", (long)countSignon);
	    		map.put("mnum", meeting.getMnum());
	    		List<ExpandedSignon> list = signOnService.SignOnList(map);

	            //要插入到二线
	            Label labelName = new Label(0, 0, "姓名");
	            Label labelSex = new Label(1, 0, "性别");
	            Label labelPhone = new Label(2, 0, "联系电话");
	            Label labelFlag = new Label(3, 0, "是否有签到");

	            writableSheet.addCell(labelName);
	            writableSheet.addCell(labelSex);
	            writableSheet.addCell(labelPhone);
	            writableSheet.addCell(labelFlag);
	          
	            for (int i = 0; i < list.size(); i++) {
	                    Label labelName_i = new Label(0, i + 1, list.get(i).getUser().getUsername());
	                    Label labelSex_i = new Label(1, i + 1, list.get(i).getUser().getUsersex());
	                    Label labelPhone_i = new Label(2, i + 1, list.get(i).getUser().getPhone());
	                    String sflagString_i = null;
	                    if(list.get(i).getSflag() != null){
	                    	if (list.get(i).getSflag() == 1) {
		                    	sflagString_i = "已签到";
							}else if (list.get(i).getSflag() != 1) {
								sflagString_i = "未签到";
							}
	                    }else {
	                    	sflagString_i = "未签到";
						}
	                    Label labelFlag_i = new Label(3, i + 1,sflagString_i);
	                    
	                    writableSheet.addCell(labelName_i);
	                    writableSheet.addCell(labelSex_i);
	                    writableSheet.addCell(labelPhone_i);
	                    writableSheet.addCell(labelFlag_i);
	                    count++;
	            }
	            //写进文档
	            writableWorkbook.write();
	            //关闭excel工作簿对象
	            writableWorkbook.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return String.valueOf(count);
	} 

	
}
