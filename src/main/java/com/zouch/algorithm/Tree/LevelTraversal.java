package com.zouch.algorithm.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Zouch
 * @date 2021/9/8 21:23
 * @description 层次遍历
 */
public class LevelTraversal extends AbstractTreeNode{


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        deque.offer(root);
        while (deque.size() > 0) {
            int count = deque.size();
            List<Integer> elementList = new ArrayList<>(2);
            while (count > 0) {
                TreeNode node = deque.poll();
                elementList.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                count--;
            }
            list.add(elementList);
        }
        return list;
    }
}