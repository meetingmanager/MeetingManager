package com.meeting.mapper;

import com.meeting.pojo.Signon;
import com.meeting.pojo.SignonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SignonMapper {
    int countByExample(SignonExample example);

    int deleteByExample(SignonExample example);

    int deleteByPrimaryKey(Integer signid);

    int insert(Signon record);

    int insertSelective(Signon record);

    List<Signon> selectByExample(SignonExample example);

    Signon selectByPrimaryKey(Integer signid);

    int updateByExampleSelective(@Param("record") Signon record, @Param("example") SignonExample example);

    int updateByExample(@Param("record") Signon record, @Param("example") SignonExample example);

    int updateByPrimaryKeySelective(Signon record);

    int updateByPrimaryKey(Signon record);
}