package com.meeting.netmeeting.service.impl;

import com.meeting.netmeeting.entity.MeetingRoom;
import com.meeting.netmeeting.mapper.MeetingRoomMapper;
import com.meeting.netmeeting.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

    @Autowired
    public MeetingRoomMapper meetingRoomMapper;

    @Override
    public int insert(MeetingRoom room) { return meetingRoomMapper.insert(room); }

    @Override
    public ArrayList<MeetingRoom> selectAll() { return meetingRoomMapper.selectAll(); }

    @Override
    public Integer SelectNameById(String dName) { return meetingRoomMapper.SelectNameById(dName); }
}
