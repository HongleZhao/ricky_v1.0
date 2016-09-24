package com.ricky.base.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by zhl on 16/9/24.
 */
@Table(name = "t_base_role_authority")
public class RoleAuthority {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "iRoleId")
    private Long roleId;

    @Column(name = "iAuthorityId")
    private Long authorityId;

    @Column(name = "vAuthority")
    private String authority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
