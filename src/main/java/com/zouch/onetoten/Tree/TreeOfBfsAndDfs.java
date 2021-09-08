package com.zouch.onetoten.Tree;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author ZouQi
 * @date 2021/8/25 下午1:13
 * 树的层次遍历和深度遍历（没有限制必须是二叉树）
 * 层次遍历思想：
 * 使用队列，出循环的条件是队列元素为空。
 * 每次出队一个节点都判断，当队列中有节点时，将其孩子都加入队列
 * 然后把节点加入list中
 * <p>
 * 深度遍历思想：
 * 节点存在子节点，则加入链表，不存在则返回。
 * 递归子节点。
 */

@Getter
@Setter
public class TreeOfBfsAndDfs {

    private TreeNode rootNode;

    @Data
    public static class TreeNode<T> {
        private T key;

        private TreeNode parent;

        private List<TreeNode> treeNodes;

        @Override
        public String toString() {
            return "key=" + key;
        }
    }

    /**
     * 层次遍历
     *
     * @param rootNode
     * @return
     */
    public static List<TreeNode> levelTraverse(TreeNode rootNode) {
        if (Objects.isNull(rootNode)) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        List<TreeNode> list = new LinkedList<>();
        while (queue.size() > 0) {
            TreeNode poll = queue.poll();
            list.add(poll);
            List<TreeNode> treeNodes = poll.getTreeNodes();
            if (CollectionUtils.isEmpty(treeNodes)) {
                continue;
            }
            queue.addAll(treeNodes);
        }
        return list;
    }

    public static List<TreeNode> result = new ArrayList<>();

    public static List<TreeNode> depthTraverse(TreeNode rootNode) {
        List<TreeNode> treeNodes = rootNode.getTreeNodes();
        result.add(rootNode);

        if (CollectionUtils.isEmpty(treeNodes)) {
            return result;
        }
        treeNodes.forEach(TreeOfBfsAndDfs::depthTraverse);
        return result;
    }

    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode();
        rootNode.setKey("root");

        TreeNode node1 = new TreeNode();
        node1.setParent(rootNode);
        node1.setKey("左孩子1");

        TreeNode node2 = new TreeNode();
        node2.setParent(rootNode);
        node2.setKey("右孩子2");

        TreeNode node3 = new TreeNode();
        node3.setParent(node2);
        node3.setKey("左孩子3");

        TreeNode node4 = new TreeNode();
        node4.setParent(node2);
        node4.setKey("右孩子4");

        TreeNode node5 = new TreeNode();
        node5.setParent(node3);
        node5.setKey("左孩子5");

        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(node1);
        treeNodes.add(node2);
        rootNode.setTreeNodes(treeNodes);

        List<TreeNode> treeNodes2 = new ArrayList<>();
        treeNodes2.add(node3);
        treeNodes2.add(node4);
        node2.setTreeNodes(treeNodes2);

        List<TreeNode> treeNodes3 = new ArrayList<>();
        treeNodes3.add(node5);
        node3.setTreeNodes(treeNodes3);

        List<TreeNode> result = levelTraverse(rootNode);
        System.out.println(result);

        List<TreeNode> result2 = depthTraverse(rootNode);
        System.out.println(result2);

    }

}
