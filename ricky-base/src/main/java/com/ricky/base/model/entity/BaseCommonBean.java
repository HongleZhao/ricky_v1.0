package com.ricky.base.model.entity;

import javax.persistence.Column;
import java.util.Date;

/**
 * 基础bean将通用的创建人、创建时间、更新人、更新时间以及删除状态抽取出来
 * Created by zhl on 16/9/19.
 */
public class BaseCommonBean {
    @Column(name = "vCreater")
    private String creater;

    @Column(name = "dCreateTime")
    private Date createTime;

    @Column(name = "vUpdater")
    private String updater;

    @Column(name = "dUpdateTime")
    private Date updateTime;

    @Column(name = "bDel")
    private boolean del;

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDel() {
        return del;
    }

    public void setDel(boolean del) {
        this.del = del;
    }
}
