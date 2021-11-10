package com.meeting.netmeeting.mapper;

import com.meeting.netmeeting.entity.MeetingRoom;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MeetingRoomMapper {
    // 添加会议室
    int insert(MeetingRoom room);

    // 查询所有会议室
    ArrayList<MeetingRoom> selectAll();

    // 根据会议室名查询会议室id
    Integer SelectNameById(String dName);
}
