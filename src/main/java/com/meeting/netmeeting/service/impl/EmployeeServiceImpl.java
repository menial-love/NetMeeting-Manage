package com.meeting.netmeeting.service.impl;

import com.meeting.netmeeting.entity.Employee;
import com.meeting.netmeeting.mapper.EmployeeMapper;
import com.meeting.netmeeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    // 根据部门id查询部门中所有员工
    public ArrayList<Employee> SelectEmployeeByDepartmentId(Integer departmentId) {
        return employeeMapper.SelectEmployeeByDepartmentId(departmentId);
    }

    @Override
    // 根据员工姓名查询员工id号
    public Integer SelectEidByName(String eName) {
        return employeeMapper.SelectEidByName(eName);
    }
}
