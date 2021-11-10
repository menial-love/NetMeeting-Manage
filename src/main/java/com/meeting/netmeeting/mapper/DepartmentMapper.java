package com.meeting.netmeeting.mapper;

import com.meeting.netmeeting.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DepartmentMapper {
    //查询所有部门
    ArrayList<Department> selectAll();
    //根据部门名称查询部门id
    Integer SelectDepartmentIdByName(String DepartmentName);
}
