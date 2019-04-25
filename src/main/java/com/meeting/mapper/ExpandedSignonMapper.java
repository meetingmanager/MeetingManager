package com.meeting.mapper;

import java.util.List;
import java.util.Map;

import com.meeting.pojo.ExpandedSignon;

public interface ExpandedSignonMapper {
	
	List<ExpandedSignon> selcetSignonList(Map<String, Long> map);
	
	Integer countSignonList(Long mnum);
}