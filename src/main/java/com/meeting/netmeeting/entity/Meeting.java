package com.meeting.netmeeting.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

// 会议详情实体类

public class Meeting {

    private Integer meetingId;  //  会议id号

    private String meetingName;   // 会议名称

    private Integer roomId;   // 会议室房间号

    private Integer reservationistId;   // 预定序列号

    private Integer numOfParticipants;  // 会议参与人数


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date beginTime;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date endTime;


    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date reservationTime;   // 会议预定时间

    private Date canceledTime;    // 会议取消时间

    private Integer meetingStatus;   // 会议状态

    private String description;  // 会议描述

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    private MeetingRoom meetingroom;  // 会议房间

    private List<Employee> employees;  // 会议参与人对象

    public MeetingRoom getMeetingRoom() {
        return meetingroom;
    }

    public void setMeetingRoom(MeetingRoom meetingroom) {
        this.meetingroom = meetingroom;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingName() {
        return meetingName;
    }

    public void setMeetingName(String meetingName) {
        this.meetingName = meetingName == null ? null : meetingName.trim();
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getReservationistId() {
        return reservationistId;
    }

    public void setReservationistId(Integer reservationistId) {
        this.reservationistId = reservationistId;
    }

    public Integer getNumOfParticipants() {
        return numOfParticipants;
    }

    public void setNumOfParticipants(Integer numofparticipants) {
        this.numOfParticipants = numofparticipants;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Date getCanceledTime() {
        return canceledTime;
    }

    public void setCanceledTime(Date canceledTime) {
        this.canceledTime = canceledTime;
    }

    public Integer getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(Integer meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
