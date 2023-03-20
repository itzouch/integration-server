package com.zouch.algorithm.sync;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Zouch
 * @date 2023/3/20 10:14
 * @description 阻塞队列使用
 */
public class ProducerAndConsumer {
    private static final BlockingQueue queue = new LinkedBlockingQueue(1024);

    public static void main(String[] args) {
        new Thread(()->{
            try {
                for (int i = 0; i < 100; i++) {
                   queue.put(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            while (queue.iterator().hasNext()){
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}