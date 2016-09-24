package com.ricky.base.realm;

import com.ricky.base.mapper.AuthorityMapper;
import com.ricky.base.mapper.SysuserMapper;
import com.ricky.base.model.entity.Authority;
import com.ricky.base.model.entity.Sysuser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 如果用户存在存储session和权限加载
 * Created by zhl on 16/9/18.
 */
public class UserLoginRealm extends AuthorizingRealm{

    @Autowired
    private SysuserMapper sysuserMapper;

    @Autowired
    private AuthorityMapper authorityMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String username = (String)principalCollection.fromRealm(getName()).iterator().next();
        Sysuser user = sysuserMapper.selectSysuserByLoginName(username);
        final List<Authority> roleAuthList = authorityMapper.selectAuthorityByRoleId(user.getRoleId());
        for(Authority authority: roleAuthList){
            info.addStringPermission(authority.getAuthority());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken toke = (UsernamePasswordToken) authenticationToken;
        Sysuser user = sysuserMapper.selectSysuserByLoginName(toke.getUsername());
        Session session = SecurityUtils.getSubject().getSession();
        if(null != user){
            session.setAttribute("userName",user.getUserName());
            session.setAttribute("name",user.getName());
            session.setAttribute("roleId",user.getRoleId());
            session.setAttribute("userId",user.getId());
            if(user.isLocked()){
                throw new LockedAccountException();
            }
            //若存在,将用户信息放到登录认证info中,在LimitRetryHashedMatcher中进行验证密码
            return new SimpleAuthenticationInfo(toke.getUsername(),user.getPassword(),getName());
        }
        return null;
    }
}
