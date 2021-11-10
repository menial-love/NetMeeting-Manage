package com.meeting.netmeeting.entity;


// 会议室实体类
public class MeetingRoom {
    private Integer roomId;  // 会议室编号

    private String roomCode;  // 会议门牌号

    private String roomName;  // 会议室名称

    private Integer roomCapacity;  // 会议室可容纳人数

    private Integer roomStatus;   // 会议室状态 可用不可用

    private String description;   // 备注和描述

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) { this.roomId = roomId; }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode == null ? null : roomCode.trim();
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(Integer roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
