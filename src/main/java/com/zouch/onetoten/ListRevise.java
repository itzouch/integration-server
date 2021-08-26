package com.zouch.onetoten;

import lombok.Data;

/**
 * @author ZouQi
 * @date 2021/8/26 下午6:44
 */
public class ListRevise {


    @Data
    public class Node{
        private Object value;

        private Node next;
    }
}
