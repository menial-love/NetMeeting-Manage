package com.meeting.netmeeting.controller;


import com.meeting.netmeeting.entity.Department;
import com.meeting.netmeeting.entity.Meeting;
import com.meeting.netmeeting.entity.MeetingParticipants;
import com.meeting.netmeeting.entity.MeetingRoom;
import com.meeting.netmeeting.service.impl.*;
import com.meeting.netmeeting.vo.MeetingDetails;
import com.meeting.netmeeting.vo.MeetingQueryRes;
import com.meeting.netmeeting.vo.Participants;
import com.meeting.netmeeting.vo.QueryMeetingCondition;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Controller
public class MeetingController {

    @Autowired
    MeetingRoomServiceImpl meetingRoomService;

    @Autowired
    DepartmentServiceImpl departmentService;

    @Autowired
    MeetingServiceImpl meetingService;

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    MeetingParticipantsServiceImpl meetingParticipantsService;

    @GetMapping("/queryroom")
    @ResponseBody
    public ArrayList<String> queryroom() {
        ArrayList<MeetingRoom> rooms = meetingRoomService.selectAll();
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0;i < rooms.size();i++) {
            names.add(rooms.get(i).getRoomName());
        }
        return names;
    }

    @GetMapping("/querydepartment")
    @ResponseBody
    public ArrayList<String> querydepartment() {
        ArrayList<Department> departments = departmentService.selectAll();
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0;i < departments.size();i++) {
            names.add(departments.get(i).getDepartmentName());
        }
        return names;
    }

    @PostMapping(value = "/bookmeeting", produces = "application/json")
    @ResponseBody
    public Map<String,String> bookMeeting(@RequestBody Meeting meeting) {
        Map<String,String> ResMap = new HashMap<>();
        // System.out.println(meeting.getBeginTime());
        if(meetingService.insert(meeting) >= 1){
            // ???????????????????????????????????????id????????????????????????
            ResMap.put("message","????????????!");
            ResMap.put("StatusCode","1");
        } else{
            ResMap.put("message","????????????!");
            ResMap.put("StatusCode","0");
        }
        return ResMap;
    }

    @PostMapping(value = "/insert/meetingpartipants/{mName}", produces = "application/json")
    @ResponseBody
    public Integer InsertMeetingPartipants(@RequestBody Map<String,ArrayList<String>> ResMap,
                                           @PathVariable("mName") String mName) {
        ArrayList<Integer> EmployIDs = new ArrayList<>();
        // ?????????????????????id???
        Integer mid = meetingService.SelectMidByMeetingName(mName);
        // ???????????????????????????id???
        for(int i = 0;i < ResMap.get("name").size();i++) {
            EmployIDs.add(employeeService.SelectEidByName(ResMap.get("name").get(i)));
        }
        MeetingParticipants participant = new MeetingParticipants();
        participant.setMeetingId(mid);
        // ???????????????meetingParticipants???
        for(int i = 0;i < EmployIDs.size();i++) {
            participant.setPaticipantsId(EmployIDs.get(i));
            int tmp = meetingParticipantsService.insert(participant);
        }
        return 1;
    }

    @PostMapping(value = "/query/meeting/outcome",produces = "application/json")
    @ResponseBody
    // ?????????????????????????????????????????????????????????????????????
    public ArrayList<MeetingQueryRes> QueryMeetingOutcome(@RequestBody QueryMeetingCondition condition) {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ?????????????????????????????????????????????????????????????????????
        ArrayList<MeetingQueryRes> meetingQueryRes = meetingService.QueryMeeting(condition);
        return meetingQueryRes;
    }

    @GetMapping(value = "/query/meetingdetails/{mid}")
    @ResponseBody
    public MeetingDetails QueryMeetingDetails(@PathVariable("mid") Integer meetingId) {
        return meetingService.SelectMeetingDetailsById(meetingId);
    }

    @GetMapping(value = "/query/meetingparticipant/{mid}")
    @ResponseBody
    public ArrayList<Participants> QueryMeetingParticipant(@PathVariable("mid") Integer meetingId) {
        ArrayList<Participants> participants = meetingService.SelectMeetingParticipantsById(meetingId);
        return participants;
    }

    @RequestMapping(value = "/download/workHoursExcel/{mid}")
    @ResponseBody
    public void downloadsExcelDown(HttpServletResponse response,
                                   @PathVariable("mid") Integer mid) throws IOException {
        ArrayList<Participants> participants = meetingService.SelectMeetingParticipantsById(mid);
        MeetingDetails meetingDetails = meetingService.SelectMeetingDetailsById(mid);
        HSSFWorkbook wb = new HSSFWorkbook(); // ??????excel??????
        HSSFSheet sheet = wb.createSheet(meetingDetails.getMeetingName() + "??????????????????"); //???????????????
        HSSFRow row = null;
        row = sheet.createRow(0); //???????????????0??????
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("??????????????????");  // ???????????????????????????0?????????????????????????????????
        // row??? col???  ???????????????????????????
        CellRangeAddress rowRegion = new CellRangeAddress(0 ,0 ,0 , 1);
        sheet.addMergedRegion(rowRegion);

        row = sheet.createRow(1); // ?????????(?????????),3????????????????????????
        row.setHeight((short) (22.50 * 20));
        row.createCell(0).setCellValue("??????");
        row.createCell(1).setCellValue("????????????");
        row.createCell(2).setCellValue("????????????");

        // ????????????????????????
        for(int i = 0;i < participants.size();i++) {
            row = sheet.createRow(i + 2);
            Participants participants1 = participants.get(i);
            row.createCell(0).setCellValue(participants1.getEmployeeName());
            row.createCell(1).setCellValue(participants1.getPhone());
            row.createCell(2).setCellValue(participants1.getEmail());
        }

        sheet.setDefaultRowHeight((short) (16.5 * 20));
        // ???????????????
        for(int i = 0; i <= 13;i++) {
            sheet.autoSizeColumn(i);
            sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 17 / 10);
        }
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os =response.getOutputStream();
        response.setHeader("Content-disposition","attachment;filename=name.xls");
        wb.write(os);
        os.flush();
        os.close();
    }
}
