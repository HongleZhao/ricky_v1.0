package com.ricky.base.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zhl on 16/9/24.
 */
@Table(name = "t_base_department")
public class Department extends BaseCommonBean {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "vDepartmentName")
    private String departmentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
