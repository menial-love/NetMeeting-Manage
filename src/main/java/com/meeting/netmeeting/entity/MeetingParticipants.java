package com.meeting.netmeeting.entity;

public class MeetingParticipants {

    private Integer Mpid;   // 表的主键

    private Integer MeetingId;   // 会议id

    private Integer PaticipantsId;  // 参会者id

    public Integer getMpid() {
        return Mpid;
    }

    public void setMpid(Integer mpid) {
        Mpid = mpid;
    }

    public Integer getMeetingId() {
        return MeetingId;
    }

    public void setMeetingId(Integer meetingId) {
        MeetingId = meetingId;
    }

    public Integer getPaticipantsId() {
        return PaticipantsId;
    }

    public void setPaticipantsId(Integer paticipantsId) {
        PaticipantsId = paticipantsId;
    }
}
