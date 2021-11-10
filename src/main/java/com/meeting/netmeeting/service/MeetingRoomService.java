package com.meeting.netmeeting.service;

import com.meeting.netmeeting.entity.MeetingRoom;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public interface MeetingRoomService {

    // 添加会议室
    int insert(MeetingRoom room);

    // 从数据库中查询所有的会议室
    ArrayList<MeetingRoom> selectAll();

    // 根据会议室名查询会议室id
    Integer SelectNameById(String dName);
}
