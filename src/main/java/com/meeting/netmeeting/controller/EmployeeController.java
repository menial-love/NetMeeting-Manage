package com.meeting.netmeeting.controller;

import com.meeting.netmeeting.entity.Employee;
import com.meeting.netmeeting.service.impl.DepartmentServiceImpl;
import com.meeting.netmeeting.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    DepartmentServiceImpl departmentService;

    @GetMapping("/queryallename/{dname}")
    public ArrayList<String> queryAllEName(@PathVariable("dname") String name) {
        // 先通过部门名查询该部门id
        Integer Did = departmentService.SelectDepartmentIdByName(name);
        // 再通过部门id查询该部门的所有员工
        ArrayList<Employee> employees = employeeService.SelectEmployeeByDepartmentId(Did);
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0;i < employees.size();i++) {
            names.add(employees.get(i).getEmployeeName());
        }
        return names;
    }


}
