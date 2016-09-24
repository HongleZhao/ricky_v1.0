package com.ricky.base.service;

/**
 * Created by zhl on 16/9/24.
 */
public interface RedisService {
    /**
     * 缓存用户登录次数,失效时间是1个小时
     * @param loginUserName
     */
    public void cacheLoginCount(String loginUserName);

    /**
     * 获取用户登录次数
     * @param loginUserName
     * @return
     */
    public Integer getLoginCount(String loginUserName);

    /**
     * 清除用户登录尝试次数
     * @param loginUserName
     */
    public void clearLoginCount(String loginUserName);
}
