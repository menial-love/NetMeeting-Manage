package com.meeting.netmeeting.entity;


// 雇员实体类描述(登录会议室的身份验证)
public class Employee {
    private Integer employeeId;  // 雇员编号

    private String employeeName;  // 雇员姓名

    private String username;   // 用户名

    private String user_pwd;  // 用户密码

    private String phone;   //雇员手机号

    private String email;

    private Integer departmentId;  // 所属部门编号 多对一关系 一个部门对应多个雇员

    private Integer roleId;   //

    private Integer employeeStatus;

    private String remark;  // 备注

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employee_id) {
        this.employeeId = employee_id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeename) {
        this.employeeName = employeename == null ? null : employeename.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String userpwd) {
        this.user_pwd = userpwd == null ? null : userpwd.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartment_id(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRole_id() { return roleId; }

    public void setRole_id(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getEmployee_status() {
        return employeeStatus;
    }

    public void setEmployee_status(Integer employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
