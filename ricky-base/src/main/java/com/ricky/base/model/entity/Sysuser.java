package com.ricky.base.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by zhl on 16/9/19.
 */
@Table(name = "t_base_sysuer")
public class Sysuser extends BaseCommonBean{

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "vName")
    private String name;

    @Column(name = "vUserName")
    private String userName;

    @Column(name = "vPassword")
    private String password;

    @Column(name = "iDepartmentId")
    private int deparmentId;

    @Column(name = "vDepartmentName")
    private String departmentName;

    @Column(name = "vTel")
    private String tel;

    @Column(name = "vPhone")
    private String phone;

    @Column(name = "vHomePhone")
    private String homePhone;

    @Column(name = "vEmail")
    private String email;

    @Column(name = "iRoleId")
    private int roleId;

    @Column(name = "vRoleName")
    private String roleName;

    @Column(name = "dLastLoginTime")
    private Date lastLoginTime;

    @Column(name = "vLoginIP")
    private String loginIP;

    @Column(name = "bLocked")
    private boolean locked;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDeparmentId() {
        return deparmentId;
    }

    public void setDeparmentId(int deparmentId) {
        this.deparmentId = deparmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
