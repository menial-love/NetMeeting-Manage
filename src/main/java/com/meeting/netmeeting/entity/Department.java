package com.meeting.netmeeting.entity;


// 部门实体类
public class Department {
    private Integer departmentId;  // 公司部门标号

    private String departmentName;  // 部门名称

    private String remark;    // 部门备注

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() { return departmentName;}

    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getRemark() { return remark; }

    public void setRemark(String remark) { this.remark = remark == null ? null : remark.trim(); }
}
