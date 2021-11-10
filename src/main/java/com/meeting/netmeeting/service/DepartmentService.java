package com.meeting.netmeeting.service;

import com.meeting.netmeeting.entity.Department;

import java.util.ArrayList;

public interface DepartmentService {
    ArrayList<Department> selectAll();
    Integer SelectDepartmentIdByName(String DepartmentName);
}
