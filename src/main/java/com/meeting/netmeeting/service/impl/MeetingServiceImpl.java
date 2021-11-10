package com.meeting.netmeeting.service.impl;

import com.meeting.netmeeting.entity.Department;
import com.meeting.netmeeting.entity.Meeting;
import com.meeting.netmeeting.mapper.DepartmentMapper;
import com.meeting.netmeeting.mapper.MeetingMapper;
import com.meeting.netmeeting.service.MeetingService;
import com.meeting.netmeeting.vo.MeetingDetails;
import com.meeting.netmeeting.vo.MeetingQueryRes;
import com.meeting.netmeeting.vo.Participants;
import com.meeting.netmeeting.vo.QueryMeetingCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MeetingServiceImpl implements MeetingService {
    @Autowired
    MeetingMapper meetingMapper;

    @Override
    public int insert(Meeting meeting) {
        return meetingMapper.insert(meeting);
    }

    @Override
    // 根据会议名称查询会议的id号
    public Integer SelectMidByMeetingName(String MeetingName) {
        return meetingMapper.SelectMidByMeetingName(MeetingName);
    }

    @Override
    // 条件查询会议
    public ArrayList<MeetingQueryRes> QueryMeeting(QueryMeetingCondition condition) {
        return meetingMapper.QueryMeeting(condition);
    }

    @Override
    // 根据会议id查询一些信息
    public MeetingDetails SelectMeetingDetailsById(Integer meetingId) {
        return meetingMapper.SelectMeetingDetailsById(meetingId);
    }

    @Override
    // 根据会议id查询会议的参会人员信息
    public ArrayList<Participants> SelectMeetingParticipantsById(Integer meetingId) {
        return meetingMapper.SelectMeetingParticipantsById(meetingId);
    }

}
