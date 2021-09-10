package com.zouch.algorithm.Tree;

import lombok.Data;

/**
 * @author Zouch
 * @date 2021/9/9 19:57
 * @description
 */
@Data
public class AbstractTreeNode {

    protected static TreeNode metaNode;

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

    /**
     * 结构如图所示
     *         5
     *        / \
     *       4  3
     *         / \
     *        1   2
     * @return
     */
    static{
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, null);
        TreeNode treeNode3 = new TreeNode(3, treeNode1, treeNode2);
        TreeNode treeNode4 = new TreeNode(4, null, null);
        metaNode = new TreeNode(5, treeNode4, treeNode3);
    }


}