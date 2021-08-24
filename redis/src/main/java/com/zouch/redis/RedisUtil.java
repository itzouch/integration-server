package com.zouch.redis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Zouch
 * @date 2021/6/22 21:10
 * @description
 */
@Component
public class RedisUtil implements ApplicationContextAware {


    public static RedisTemplate redisTemplate;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("!1111111");
        RedisUtil.redisTemplate = (RedisTemplate)applicationContext.getBean("redisTemplate");

    }

//    @Override
//    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
//        System.out.println("!1111111");
//
//        RedisUtil.redisTemplate = (RedisTemplate)configurableApplicationContext.getBean("redisTemplate");
//    }
}