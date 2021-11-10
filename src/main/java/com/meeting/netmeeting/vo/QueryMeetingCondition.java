package com.meeting.netmeeting.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class QueryMeetingCondition {

    private String meetingName;

    private String roomName;

    private String reserverName;

    //@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    //由于我们只希望使用这个条件在数据库中寻找合适的时间范围，因此将其设计为String类型更为合适
    private String reserveTimeStart;

    private String reserveTimeEnd;

    private String meetingStart;

    private String meetingEnd;

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getReserverName() {
        return reserverName;
    }

    public void setReserverName(String reserverName) {
        this.reserverName = reserverName;
    }

    public String getReserveTimeStart() {
        return reserveTimeStart;
    }

    public void setReserveTimeStart(String reserveTimeStart) {
        this.reserveTimeStart = reserveTimeStart;
    }

    public String getReserveTimeEnd() {
        return reserveTimeEnd;
    }

    public void setReserveTimeEnd(String reserveTimeEnd) {
        this.reserveTimeEnd = reserveTimeEnd;
    }

    public String getMeetingStart() {
        return meetingStart;
    }

    public void setMeetingStart(String meetingStart) {
        this.meetingStart = meetingStart;
    }

    public String getMeetingEnd() {
        return meetingEnd;
    }

    public void setMeetingEnd(String meetingEnd) {
        this.meetingEnd = meetingEnd;
    }
}
