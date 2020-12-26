package com.jesse.learn.algorithm.tree;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的遍历（前序、中序、后序、层序）
 */
public class TreeSearch {

    private static final String SEP = ",";
    private static final String NULL = "#";

    private void preOrderPrint(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }

        System.out.print(rootNode.getData() + SEP);
        preOrderPrint(rootNode.getLeft());
        preOrderPrint(rootNode.getRight());
    }

    private void postOrderPrint(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }

        postOrderPrint(rootNode.getLeft());
        postOrderPrint(rootNode.getRight());
        System.out.print(rootNode.getData() + SEP);
    }

    private void inOrderPrint(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }

        inOrderPrint(rootNode.getLeft());
        System.out.print(rootNode.getData() + SEP);
        inOrderPrint(rootNode.getRight());
    }

    private void levelOrderPrint(TreeNode treeNode) {
        if (treeNode == null) {
            System.out.print(NULL);
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (NULL.equals(node.getData())) {
                    continue;
                }
                System.out.print(node.getData() + SEP);

                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                } else {
                    queue.offer(new TreeNode(NULL));
                }

                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                } else {
                    queue.offer(new TreeNode(NULL));
                }
            }
        }
    }

    public static void main(String[] args) {

        TreeBuilding treeBuilding = new TreeBuilding();
        // 层序构建二叉树
        String levelOrderStr = "1,2,3,4,5,6,7,8,#,#,9,#,#,10,#";
        TreeNode rootNode = treeBuilding.levelorder(treeBuilding.buildLinkedList(levelOrderStr));
        System.out.println(JSON.toJSONString(rootNode));

        TreeSearch treeSearch = new TreeSearch();
        // 前序遍历
        treeSearch.preOrderPrint(rootNode);
        System.out.println();

        // 后序遍历
        treeSearch.postOrderPrint(rootNode);
        System.out.println();

        // 中序遍历
        treeSearch.inOrderPrint(rootNode);
        System.out.println();

        // 层序遍历
        treeSearch.levelOrderPrint(rootNode);
    }
}
