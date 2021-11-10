package com.meeting.netmeeting.mapper;

import com.meeting.netmeeting.entity.MeetingParticipants;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingParticipantsMapper {
    // 插入一条记录
    int insert(MeetingParticipants meetingParticipants);
}
