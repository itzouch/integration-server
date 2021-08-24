package com.zouch.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * @author Zouch
 * @date 2021/6/22 21:07
 * @description 超卖问题
 */


@Slf4j
@SpringBootTest(classes = RedisApplication.class)
@RunWith(SpringRunner.class)
public class RedisTest extends RedisApplicationTests{

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test(){

        String key = "zz";

        RedisTemplate redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");

        Boolean zz  = redisTemplate.opsForValue().setIfAbsent(key, 10,10, TimeUnit.SECONDS);
        if (!zz){
            log.info("获取分布式锁FAILED");
        }
        try {
            int num = (int) redisTemplate.opsForValue().get("stock");
            log.info("当前剩余库存{}",num);
            if (num>0){
                int stock = num-1;
                redisTemplate.opsForValue().set("stock", stock);
            }else {
                log.info("扣减失败，库存不足");
            }
        } finally {
            redisTemplate.delete(key);
        }


    }


    @Test
    public void test1(){
        RedisTemplate redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        HashOperations hashOperations = redisTemplate.opsForHash();


        ListOperations listOperations = redisTemplate.opsForList();
        SetOperations setOperations = redisTemplate.opsForSet();
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();


    }

    @Test
    public void test2(){
        ConcurrentHashMap<Integer,Integer> integerIntegerConcurrentHashMa = new ConcurrentHashMap<>();
        integerIntegerConcurrentHashMa.put(1,2);
        Integer integer = integerIntegerConcurrentHashMa.get(1);
        System.out.println(integer);
        List list = new ArrayList(11);

        list.add(1);
    }
}