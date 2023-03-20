package com.zouch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zouch
 * @date 2021/6/16 20:31
 * @description
 */
@RestController(value = "/test")
public class DispatcherServletTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherServletTest.class);

    @GetMapping("/get")
    public void test(){
        System.out.println("接收到request");
    }
}