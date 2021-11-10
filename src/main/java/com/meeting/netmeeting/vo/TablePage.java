package com.meeting.netmeeting.vo;

import com.meeting.netmeeting.entity.MeetingRoom;

import java.util.ArrayList;

public class TablePage {

    ArrayList<MeetingRoom> rooms;

    Integer CurrentPage;

    Integer TotalPage;

    Integer TotalNum;

    public ArrayList<MeetingRoom> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<MeetingRoom> rooms) {
        this.rooms = rooms;
    }

    public Integer getCurrentPage() {
        return CurrentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        CurrentPage = currentPage;
    }

    public Integer getTotalPage() {
        return TotalPage;
    }

    public void setTotalPage(Integer totalPage) {
        TotalPage = totalPage;
    }

    public Integer getTotalNum() {
        return TotalNum;
    }

    public void setTotalNum(Integer totalNum) {
        TotalNum = totalNum;
    }
}
