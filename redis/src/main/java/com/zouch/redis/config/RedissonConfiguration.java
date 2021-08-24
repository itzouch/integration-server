package com.zouch.redis.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zouch
 * @date 2021/6/22 22:22
 * @description
 */
@RestController
public class RedissonConfiguration {

    static Object object;
    static List<Object> list = new ArrayList<>();
    @RequestMapping("/addlist")
    public  void list(@RequestParam("value") Integer value) throws InterruptedException {
        byte[] bytes = new byte[value * 1024 * 1024];
        list.add(bytes);
    }

    @RequestMapping("/clearlist")
    public  void clearlist() throws InterruptedException {
        list.clear();
    }

}