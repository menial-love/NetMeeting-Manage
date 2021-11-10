package com.meeting.netmeeting.controller;


import ch.qos.logback.core.util.InvocationGate;
import com.meeting.netmeeting.entity.MeetingRoom;
import com.meeting.netmeeting.service.impl.MeetingRoomServiceImpl;
import com.meeting.netmeeting.vo.TablePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Controller
public class MeetingRoomController {

    @Autowired
    MeetingRoomServiceImpl meetingRoomService;

    @RequestMapping("/")
    public String index() {
        return "adminindex";
    }

    @RequestMapping(value = "/addroom",method = RequestMethod.GET)
    public String addMeetingRoomPage1() {
        return "addmeetingroom";
    }

    @RequestMapping(value = "/addroom", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String,String> addMeetingRoomPage(@RequestBody Map<String,String> conditionMap) {

        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setRoomCode(conditionMap.get("rcode"));
        meetingRoom.setRoomName(conditionMap.get("rname"));

        meetingRoom.setRoomCapacity(Integer.parseInt(conditionMap.get("rcapacity")));
        meetingRoom.setRoomStatus(Integer.parseInt(conditionMap.get("rstatus")));
        meetingRoom.setDescription(conditionMap.get("des"));
        Map<String,String> ResMap = new HashMap<>();
        if(meetingRoomService.insert(meetingRoom) >= 1) {
            ResMap.put("message", "添加成功!");
            ResMap.put("StatusCode", "1");
        } else {
            ResMap.put("message","添加失败!");
            ResMap.put("StatusCode", "0");
        }
        return ResMap;
    }

    @PostMapping("/showmeetingrooms/{CurrentPage}")
    @ResponseBody
    // 在后端对结果进行分页
    public Map<String,TablePage> show(@PathVariable("CurrentPage")String page) {
        Map<String, TablePage> ResMap = new HashMap<>();
        TablePage table = new TablePage();
        // 从数据库中查询所有的会议室
        ArrayList<MeetingRoom> rooms = meetingRoomService.selectAll();
        ArrayList<MeetingRoom> OnePage_room = new ArrayList<>();
        // 一页显示8条数据，所以应该显示从(当前页-1)*8 到 （当前页码-1）*8 + 8条数据
        int totalNum = rooms.size();
        int totalPage;
        if(totalNum % 8 == 0) {
            totalPage = totalNum / 8;
        } else {
            totalPage = totalNum / 8 + 1;
        }
        int currentPage = Integer.parseInt(page);
        // 在后端进行分页
        if(currentPage == totalPage) {
            // 若当前页是最后一页则数据不一定能够刚好取出8条，应该分出该特殊情况进行处理
            for(int i = (currentPage-1)*8;i < totalNum;i++) {
                OnePage_room.add(rooms.get(i));
            }
        }else if(currentPage == 1 && totalNum <= 8) {
            for(int i = 0;i < totalNum;i++) {
                OnePage_room.add(rooms.get(i));
            }
        }else {
            for(int i = (currentPage-1)*8;i < (currentPage-1)*8 + 8;i++){
                OnePage_room.add(rooms.get(i));
            }
        }
        table.setRooms(OnePage_room);
        table.setCurrentPage(currentPage);
        table.setTotalPage(totalPage);
        table.setTotalNum(totalNum);
        ResMap.put("table",table);
        return ResMap;
    }

    @GetMapping(value = "/queryrid/{name}")
    @ResponseBody
    public Integer QueryRid(@PathVariable("name")String name) {
        return meetingRoomService.SelectNameById(name);
    }

}
