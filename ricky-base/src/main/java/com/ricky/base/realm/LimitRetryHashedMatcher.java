package com.ricky.base.realm;

import com.ricky.base.common.util.MD5Kit;
import com.ricky.base.emnu.ErrType;
import com.ricky.base.service.RedisService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * 用户登录用户名密码验证以及尝试次数
 * Created by zhl on 16/9/18.
 */
public class LimitRetryHashedMatcher extends HashedCredentialsMatcher {
    private final static Logger logger = LoggerFactory.getLogger(LimitRetryHashedMatcher.class);

    @Resource
    private RedisService redisService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authToken, AuthenticationInfo info) {
        UsernamePasswordToken token = (UsernamePasswordToken)authToken;
        String username = token.getUsername();
        //一个小时内只能尝试4次登录
        Integer count = redisService.getLoginCount(username);
        if(count>4){
            throw new ExcessiveAttemptsException();
        }
        Object tokenCredentials = encrypt(username,String.valueOf(token.getPassword()));
        Object accountCredentials = info.getCredentials();
        //将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
        if(logger.isDebugEnabled()){
            logger.debug("===>"+tokenCredentials+"  "+accountCredentials);
        }
        boolean success = equals(tokenCredentials, accountCredentials);
        if(!success){
            logger.info("====>>>user:["+username+"] login fail,wrong password!");
            redisService.cacheLoginCount(username);
            StringBuffer buffer = new StringBuffer(ErrType.ILLEGAL_ACCOUNT_PASSWORD.getErrmsg());
            if((4-count)>0){
                buffer.append(",你还有"+(4-count)+"次机会");
            }else {
                buffer.append(",失败次数过多，一小时后再试");
            }
            throw new AuthenticationException(buffer.toString());
        }else {
            logger.info("====>>>user:["+username+"] login success!");
            redisService.clearLoginCount(username);
        }
        return success;
    }

    /**
     * 根据用户名和密码对密码加密,同时加上盐
     * @param username
     * @param password
     * @return
     */
    private String encrypt(String username,String password) {
        String encryPwd = MD5Kit.encodeSalt(password, username);
        return encryPwd;
    }
}
