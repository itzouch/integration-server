package com.zouch.sync;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Zouch
 * @date 2023/3/8 8:33
 * @description
 */
public class ThreadPoolTest {



    public static void main(String[] args) {
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setCorePoolSize(2);
        poolTaskExecutor.setMaxPoolSize(3);
        poolTaskExecutor.setQueueCapacity(1);
        poolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        poolTaskExecutor.initialize();
        poolTaskExecutor.execute(()-> {
                System.out.println("我是task1");
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        poolTaskExecutor.execute(()-> {
                    System.out.println("我是task2");
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        poolTaskExecutor.execute(()-> {
                    System.out.println("我是task3");
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        System.out.println("活跃的线程数："+poolTaskExecutor.getActiveCount());
        poolTaskExecutor.execute(()-> {
                    System.out.println("我是task4");
                    try {
                        Thread.sleep(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}