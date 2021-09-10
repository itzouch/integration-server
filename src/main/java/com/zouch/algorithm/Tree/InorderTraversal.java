package com.zouch.algorithm.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zouch
 * @date 2021/9/8 20:22
 * @description 中序遍历 递归法、迭代法
 */
public class InorderTraversal extends AbstractTreeNode{



    /**
     * 1.根节点不为null，入栈，root = root.left
     * 2.根节点为null,出栈，val加入list root = root.right
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> element = new ArrayList<>(10);
        Deque<TreeNode> deque = new LinkedList<>();
        while (root != null || deque.size() > 0) {
            if (root != null) {
                deque.push(root);
                root = root.left;
            } else {
                root = deque.pop();
                element.add(root.val);
                root = root.right;
            }
        }
        return element;
    }

    /**
     * 递归法
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> element = new ArrayList<>(10);
        inOrder(root, element);
        return element;
    }

    private static void inOrder(TreeNode root, List<Integer> element) {
        if (root == null) {
            return;
        }
        inOrder(root.left, element);
        element.add(root.val);
        inOrder(root.right, element);
    }

    public static void main(String[] args) {
        List<Integer> list = inorderTraversal(metaNode);
        System.out.println(list.toString());
        List<Integer> list1 = inorderTraversal2(metaNode);
        System.out.println(list.toString());
    }

}