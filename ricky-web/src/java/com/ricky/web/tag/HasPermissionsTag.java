package com.ricky.web.tag;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.tags.PermissionTag;

/**
 * Created by zhl on 16/9/24.
 */
public class HasPermissionsTag extends PermissionTag {

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected boolean showTagBody(String s) {
        Subject subject = SecurityUtils.getSubject();
        if (subject == null) return false;
        if (StringUtils.isBlank(name)) return false;
        String permissions[] = name.split(";");
        for (String perm : permissions) {
            if (subject.isPermitted(perm))
                return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
