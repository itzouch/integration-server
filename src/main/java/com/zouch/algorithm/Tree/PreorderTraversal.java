package com.zouch.algorithm.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zouch
 * @date 2021/9/9 19:57
 * @description 前序遍历  递归法、迭代法
 */
public class PreorderTraversal extends AbstractTreeNode {
    public static List<Integer> traversalByRecursive(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>(10);
        traversalByRecursive(node, list);
        return list;
    }

    public static void traversalByRecursive(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traversalByRecursive(root.left, list);
        traversalByRecursive(root.right, list);
    }

    public static List<Integer> traversalByIteration(TreeNode root) {
        if (root ==null ){
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || deque.size() > 0) {
            if (root != null) {
                deque.push(root);
                list.add(root.val);
                root = root.left;
            } else {
                root = deque.pop();
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = traversalByRecursive(metaNode);
        System.out.println(list.toString());
        List<Integer> list1 = traversalByIteration(metaNode);
        System.out.println(list1.toString());
    }
}