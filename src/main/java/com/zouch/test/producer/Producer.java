package com.zouch.test.producer;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zouch
 * @date 2021/7/6 21:25
 * @description 两个线程循环打印1-100
 */

@Data
public class Producer {
    private int i = 0;

    private ReentrantLock lock = new ReentrantLock();

    public void test() {

        new Thread(() -> {

            while (i < 100) {
                lock.lock();
                try {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + "---" + i);
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }

        }, "thread1").start();

        new Thread(() -> {
            while (i < 100) {
                lock.lock();
                try {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + "---" + i);
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }, "thread2").start();
    }

    public static void main(String[] args) throws InterruptedException {
        Producer keyGenerateUtil = new Producer();
        keyGenerateUtil.test();




    }



}
    


