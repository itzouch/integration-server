package com.zouch.algorithm;

import lombok.Data;

import java.util.*;

/**
 * @author ZouQi
 * @date 2021/8/26 下午6:44
 */
public class ListRevise {



    public static class Node<N> {
        N key;
        Object next;

        public Node(N no, Object next) {
            this.key = no;
            this.next = next;
        }

        @Override
        public String toString() {
            return "key" + key;
        }
    }

    @Data
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            // 保存当前结点的next结点
            ListNode next = cur.next;
            // 当前节点的next指向pre
            cur.next = pre;
            // pre指向当前结点
            pre = cur;
            // 当前节点等于next
            cur = next;
        }
        return pre;
    }


    public static void sort(List<Node> integers) {
//        LinkedList<Node> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        integers.forEach(stack::push);
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
//        list.forEach(node -> System.out.println(node.toString()));
    }


    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, node1);
        Node node3 = new Node(3, node2);
        Node node4 = new Node(4, node3);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        sort(list);
        ListNode listNode = new ListNode(1, null);
        ListNode listNode2 = new ListNode(2, listNode);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode1 = reverseList(listNode3);
        System.out.println(listNode1.toString());

        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.addFirst(4);
        deque.addLast(5);
        deque.push(6);
        Integer pop = deque.pop();
        System.out.println(pop);
        deque.offer(7);
        Integer poll = deque.poll();
        System.out.println(poll);

    }
}
