package com.zouch.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zouch
 * @date 2023/3/14 10:41
 * @description  用单个队列实现栈的功能   每次取元素把除队头外的其他元素先取出来 再放回去 这样队头元素就移到了队尾
 */
public class QueueAndStack {

    public static void main(String[] args) {
        Queue<Integer> deque = new LinkedList<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.offer(4);
        deque.offer(5);
        while (deque.size()>0){
            for (int i = 0; i < deque.size()-1; i++) {
                Integer poll = deque.poll();
                deque.offer(poll);
            }
            System.out.println(deque.poll());
        }
    }
}