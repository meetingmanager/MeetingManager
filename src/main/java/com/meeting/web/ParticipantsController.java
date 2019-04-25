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

import com.meeting.pojo.ParticipantsExample;
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
	 *����mnum��ȡ�û���Ĳλ���Ա
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

	/**
	 * ����pname��ȡ�û���Ĳλ���Ա
	 * @param pname
	 * @return
	 */
	@RequestMapping(value="findByPname")
	public ModelAndView findParticipantsByPname(HttpSession session,String pname){
		ModelAndView movi = new ModelAndView();
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		List<Participants> list = participantsService.findPartipantsByPname(pname,meeting.getMnum());

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
	
	@RequestMapping(value="updateByPnum",method=RequestMethod.POST)
	public void updateParticipantsByPnum(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		String pnum = request.getParameter("pnum");
		String pflag = request.getParameter("pflag");
		int intPnum = Integer.parseInt(pnum);
		int intPflag = Integer.parseInt(pflag);
		System.out.println(pnum+ "::"+pflag);
		participantsService.updatePartipants(intPnum, intPflag);
		
		/*
		 * ������֮���״̬�밴��json���ݴ��ĸ�ʽ���뵽��Ӧ���û���
		 * */
		
		//��ȡ���û���
		Participants participants = participantsService.findPartipantsByPnum(intPnum);
		//�޸��û��λ��
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
		//��ȥPrintWriter������
		PrintWriter out = response.getWriter();
		//��������ɹ�
  		out.write("{\"status\":1}");
  		//ˢ�»��棬�ܹ��ý����߸������
  		out.flush();
	}
	
	/*
	 * �λ���Աչʾ
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
	 * ���ݻ���ţ����زλ���Ա״̬��Ϊ1����׼�λᣩ��2���ܾ��λᣩ
	 * */
	@RequestMapping(value="selectMP",method=RequestMethod.POST)
	public List<Participants> selectMP(HttpSession session){
		Meeting meeting = (Meeting) session.getAttribute("meeting");
		List<Participants> list = participantsService.findPartpantsByMP(meeting.getMnum());
		return list;
	}
	
	/*
	 * �������ĳ����
	 * */
	@RequestMapping(value="applyJoinMeeting")
	public ModelAndView applyJoinMeeting(long mnum,HttpServletRequest request){
		ModelAndView movi = new ModelAndView();
		/*
		 * �жϻ����Ƿ�Ϊ��ǰ�û������ģ����ǣ������������
		 * ������
		 * */
		Participants participants = new Participants();
		
		//��ȡ��ǰ�û�
		Cookie[] cookies = request.getCookies();
		String userid = null;
		for (Cookie c : cookies) {
			if(c.getName().equals("userid")){
				userid = c.getValue();
			}
		}
		
		/*
		 * �ж��Ƿ��ظ����뱾�λ���
		 * */
		int pnum = participantsService.selectPnumByMnumAndUserid(mnum, userid);
		User user = userService.findUserById(userid);
		if(pnum == 0){
			/*
			 * �жϸ��û��Ƿ����������ֺ��ֻ�����
			 * */
			if(user.getUsername() == null || user.getUsername() == "" || user.getPhone() == null || user.getPhone() == ""){
				String message = "�װ����û�������δ�����������ֺ͵绰���룬�뵽�û���Ϣ��������û���Ϣ";
				movi.addObject("message", message);
			}else{
				//���Ʋλ���Ա��Ϣ
				participants.setUserid(user.getUserid());
				participants.setMnum(mnum);
				participants.setPname(user.getUsername());
				participants.setPsex(user.getUsersex());
				participants.setPphone(user.getPhone());
				participantsService.applyJoinMeeting(participants);
				String message = "�װ����û�����л��������뱾�λ��飬�����ĵȴ�����";
				movi.addObject("message", message);
			}
		}else{
			String message = "�װ����û������Ѿ�������뱾�λ��飬�����ĵȴ�����";
			movi.addObject("message", message);
		}

		//�λ���Ա�ĵ�λ
		//δ����
		
		movi.setViewName("joinMeeting");
		return movi;
	}
}
