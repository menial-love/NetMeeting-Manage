package com.meeting.netmeeting.entity;

public class Role {

    private Integer roleId;  // 角色id

    private String roleName;  // 身份，分为管理员和普通员工

    private String remark;  // 备注

    public Integer getRoleId() { return roleId; }

    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public String getRoleName() { return roleName; }

    public void setRoleName(String roleName) { this.roleName = roleName == null ? null : roleName.trim(); }

    public String getRemark() { return remark; }

    public void setRemark(String remark) { this.remark = remark == null ? null : remark.trim(); }

}
