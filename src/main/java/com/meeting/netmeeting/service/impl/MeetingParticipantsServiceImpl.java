package com.meeting.netmeeting.service.impl;

import com.meeting.netmeeting.entity.MeetingParticipants;
import com.meeting.netmeeting.mapper.MeetingParticipantsMapper;
import com.meeting.netmeeting.service.MeetingParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingParticipantsServiceImpl implements MeetingParticipantsService {
    @Autowired
    MeetingParticipantsMapper  meetingParticipantsMapper;

    @Override
    public int insert(MeetingParticipants meetingParticipants) {
        return meetingParticipantsMapper.insert(meetingParticipants);
    }
}
