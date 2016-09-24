package com.ricky.base.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zhl on 16/9/24.
 */
@Table(name = "t_base_authority")
public class Authority extends BaseCommonBean {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "vAuthId")
    private String authId;

    @Column(name = "vParentId")
    private String parentId;

    @Column(name = "vAuthority")
    private String authority;

    @Column(name = "vName")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
