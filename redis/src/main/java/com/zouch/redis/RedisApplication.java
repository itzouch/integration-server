package com.zouch.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RedisApplication {


    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
        test("2","2");
    }
    public static void test(String... strings){
        System.out.println(strings.toString());
    }


}
