package com.zouch.onetoten.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zouch
 * @date 2021/9/8 20:22
 * @description
 */
public class InOrdeTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode1, treeNode2);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode5 = new TreeNode(5, treeNode4, treeNode3);
        List<Integer> list = inorderTraversal((treeNode5));
        System.out.println(list.toString());
    }

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

}