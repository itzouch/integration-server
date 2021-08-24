package com.zouch.productorAndConsumer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zouch
 * @date 2021/7/6 21:25
 * @description
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
//        Producer keyGenerateUtil = new Producer();
//        keyGenerateUtil.test();
//
//        int [] a = new int[2];

        System.out.println(reverse(1534236469));

    }
    public static int reverse(int x) {
        StringBuilder str = new StringBuilder();
        if(x<0){
            x = -x;
            str.append("-");
        }
        String b = String.valueOf(x);
        char[] array = b.toCharArray();

        for (int i = array.length-1; i >=0 ; i--) {
            str.append(array[i]);
        }
        String s = String.valueOf(str);
        System.out.println(s);
        return Integer.parseInt(s);
    }


}
    


