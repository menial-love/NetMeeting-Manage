package com.meeting.netmeeting.mapper;

import com.meeting.netmeeting.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface EmployeeMapper {
    // 根据部门id查询部门中所有员工
    ArrayList<Employee> SelectEmployeeByDepartmentId(Integer departmentId);

    // 根据员工姓名查询员工id号
    Integer SelectEidByName(String eName);
}
