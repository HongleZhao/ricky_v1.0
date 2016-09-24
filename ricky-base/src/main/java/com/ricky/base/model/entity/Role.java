package com.ricky.base.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zhl on 16/9/24.
 */
@Table(name = "t_base_role")
public class Role extends BaseCommonBean {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "vRoleNameCN")
    private String roleNameCN;

    @Column(name = "vRoleNameEN")
    private String roleNameEN;

    @Column(name = "vDescription")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleNameCN() {
        return roleNameCN;
    }

    public void setRoleNameCN(String roleNameCN) {
        this.roleNameCN = roleNameCN;
    }

    public String getRoleNameEN() {
        return roleNameEN;
    }

    public void setRoleNameEN(String roleNameEN) {
        this.roleNameEN = roleNameEN;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
