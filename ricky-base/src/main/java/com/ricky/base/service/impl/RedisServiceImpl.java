package com.ricky.base.service.impl;

import com.ricky.base.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhl on 16/9/24.
 */
@Resource
public class RedisServiceImpl implements RedisService {

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;

    /**
     * 缓存用户登录次数,失效时间是1个小时
     * @param loginUserName
     */
    @Override
    public void cacheLoginCount(String loginUserName) {
        Object times = redisTemplate.opsForValue().get(loginUserName);
        if (null != times) {
            redisTemplate.opsForValue().set(loginUserName, (Integer) times + 1, 1, TimeUnit.HOURS);
        } else {
            redisTemplate.opsForValue().set(loginUserName, 1, 1, TimeUnit.HOURS);
        }
    }

    /**
     * 获取用户登录次数
     * @param loginUserName
     * @return
     */
    @Override
    public Integer getLoginCount(String loginUserName) {
        Object times = redisTemplate.opsForValue().get(loginUserName);
        if (null != times) {
            return (Integer) times;
        }
        return 0;
    }

    @Override
    public void clearLoginCount(String loginUserName) {
        redisTemplate.opsForValue().set(loginUserName, 0, 5, TimeUnit.SECONDS);
    }
}
