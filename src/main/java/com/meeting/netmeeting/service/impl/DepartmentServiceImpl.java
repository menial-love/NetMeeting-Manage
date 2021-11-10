package com.meeting.netmeeting.service.impl;

import com.meeting.netmeeting.entity.Department;
import com.meeting.netmeeting.mapper.DepartmentMapper;
import com.meeting.netmeeting.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public ArrayList<Department> selectAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public Integer SelectDepartmentIdByName(String DepartmentName) {
        return departmentMapper.SelectDepartmentIdByName(DepartmentName);
    }
}
