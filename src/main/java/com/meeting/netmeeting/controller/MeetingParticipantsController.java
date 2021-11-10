package com.meeting.netmeeting.controller;

import com.meeting.netmeeting.service.impl.MeetingParticipantsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeetingParticipantsController {
    @Autowired
    MeetingParticipantsServiceImpl meetingParticipantsService;
    
}
