package com.zouch.algorithm.Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ZouQi
 * @date 2021/9/28 下午4:31
 * @description 反转二叉树
 */
public class TreeRevise extends AbstractTreeNode {

    public TreeNode revise(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(treeNode);
        while (deque.size() > 0) {
            TreeNode treeNode1 = deque.pop();
            TreeNode tamp = treeNode1.left;
            treeNode1.left = treeNode1.right;
            treeNode1.right = tamp;
            if (treeNode1.left != null) {
                deque.push(treeNode1.left);
            }
            if (treeNode1.left != null) {
                deque.push(treeNode1.right);
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        TreeRevise treeRevise = new TreeRevise();
        System.out.println(treeRevise.revise(metaNode));
        System.out.println(1);
    }

}
