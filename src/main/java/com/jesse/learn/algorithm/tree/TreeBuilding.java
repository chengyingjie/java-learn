package com.jesse.learn.algorithm.tree;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBuilding {

    private static final String SEP = ",";
    private static final String NULL = "#";


    public TreeNode preorder(Queue<String> queue) {

        if (queue.isEmpty()) {
            return null;
        }

        String node = queue.poll();
        if (node.equals(NULL)) {
            return null;
        }

        TreeNode treeNode = new TreeNode(node);
        treeNode.setLeft(preorder(queue));
        treeNode.setRight(preorder(queue));

        return treeNode;
    }

    public TreeNode postorder(LinkedList<String> queue) {

        if (queue.isEmpty()) {
            return null;
        }

        String node = queue.removeLast();
        if (node.equals(NULL)) {
            return null;
        }

        TreeNode treeNode = new TreeNode(node);
        treeNode.setRight(postorder(queue));
        treeNode.setLeft(postorder(queue));

        return treeNode;
    }

    public TreeNode levelorder(List<String> nodes) {
        if (CollectionUtils.isEmpty(nodes)) {
            return null;
        }

        TreeNode root = new TreeNode(nodes.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < nodes.size();) {
            TreeNode parent = queue.poll();

            String leftData = nodes.get(i++);
            if (!leftData.equals(NULL)) {
                parent.setLeft(new TreeNode(leftData));
                queue.offer(parent.getLeft());
            }

            String rightData = nodes.get(i++);
            if (!rightData.equals(NULL)) {
                parent.setRight(new TreeNode(rightData));
                queue.offer(parent.getRight());
            }
        }

        return root;
    }

    public TreeNode buildByPreAndInOrder(List<String> preOrderList, List<String> inOrderList) {
        return null;
    }

    public TreeNode buildByInAndPostOrder(List<String> inOrderList, List<String> postOrderList) {
        return null;
    }


    public static void main(String[] args) {
        String preOrderStr = "1,2,4,8,#,#,#,5,#,9,#,#,3,6,#,#,7,10,#,#,#";
        String postOrderStr = "#,#,8,#,4,#,#,#,9,5,2,#,#,6,#,#,10,#,7,3,1";
        String inOrderStr = "#,8,#,4,#,2,#,5,#,#,9,1,#,6,#,3,#,10,#,7,#";
        String levelOrderStr = "1,2,3,4,5,6,7,8,#,#,9,#,#,10,#";

        TreeBuilding treeBuilding = new TreeBuilding();

        // 前序遍历构建二叉树
        TreeNode preOrderRootNode = treeBuilding.preorder(treeBuilding.buildQueue(preOrderStr));
        System.out.println(JSON.toJSONString(preOrderRootNode));

        // 后续遍历构建二叉树
        TreeNode postOrderRootNode = treeBuilding.postorder(treeBuilding.buildLinkedList(postOrderStr));
        System.out.println(JSON.toJSONString(postOrderRootNode));

        // 中序遍历无法构建二叉树

        // 层序遍历构建二叉树
        TreeNode leveOrderRootNode = treeBuilding.levelorder(treeBuilding.buildLinkedList(levelOrderStr));
        System.out.println(JSON.toJSONString(leveOrderRootNode));

        List<String> preOrderList = treeBuilding.buildLinkedList("1,2,4,8,5,9,3,6,7,10");
        List<String> postOrderList = treeBuilding.buildLinkedList("8,4,9,5,2,6,10,7,3,1");
        List<String> inOrderList = treeBuilding.buildLinkedList("8,4,2,5,9,1,6,3,10,7");
        // 根据前序、中序构建二叉树
        TreeNode treeNode1 = treeBuilding.buildByPreAndInOrder(preOrderList, inOrderList);
        System.out.println(JSON.toJSONString(treeNode1));

        // 根据中序、后序构建二叉树
        TreeNode treeNode2 = treeBuilding.buildByInAndPostOrder(inOrderList, postOrderList);
        System.out.println(JSON.toJSONString(treeNode2));
    }

    public LinkedList<String> buildLinkedList(String orderStr) {
        LinkedList<String> orderList = new LinkedList<>();
        for (String str : orderStr.split(SEP)) {
            orderList.add(str);
        }

        return orderList;
    }

    public Queue<String> buildQueue(String orderStr) {
        Queue<String> orderQueue = new LinkedList<>();
        for (String str : orderStr.split(SEP)) {
            orderQueue.offer(str);
        }

        return orderQueue;
    }
}
