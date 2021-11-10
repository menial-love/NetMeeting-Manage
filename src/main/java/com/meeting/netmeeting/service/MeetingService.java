package com.meeting.netmeeting.service;

import com.meeting.netmeeting.entity.Department;
import com.meeting.netmeeting.entity.Meeting;
import com.meeting.netmeeting.vo.MeetingDetails;
import com.meeting.netmeeting.vo.MeetingQueryRes;
import com.meeting.netmeeting.vo.Participants;
import com.meeting.netmeeting.vo.QueryMeetingCondition;

import java.util.ArrayList;

public interface MeetingService {
    int insert(Meeting meeting);

    // 根据会议名称查询会议的id号
    Integer SelectMidByMeetingName(String MeetingName);

    // 条件查询会议
    ArrayList<MeetingQueryRes> QueryMeeting(QueryMeetingCondition condition);

    // 根据会议id查询一些信息
    MeetingDetails SelectMeetingDetailsById(Integer meetingId);

    // 根据会议id查询会议的参会人员信息
    ArrayList<Participants> SelectMeetingParticipantsById(Integer meetingId);
}
