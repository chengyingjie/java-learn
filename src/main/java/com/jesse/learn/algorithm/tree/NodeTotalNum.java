package com.jesse.learn.algorithm.tree;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

public class NodeTotalNum {


//    /**
//     * 层序遍历数组构建二叉树
//     *
//     * @param array
//     * @return
//     */
//    public List<TreeNode> buildBinTreeByLevelOrder(int[] array) {
//
//        List<TreeNode> treeNodeList = new LinkedList<>();
//
//        // 将一个数组的值依次转换为Node节点
//        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
//            treeNodeList.add(new TreeNode(array[nodeIndex]));
//        }
//
//        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
//        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
//            // 左孩子
//            treeNodeList.get(parentIndex).setLeft(treeNodeList.get(parentIndex * 2 + 1));
//            // 右孩子
//            treeNodeList.get(parentIndex).setRight(treeNodeList.get(parentIndex * 2 + 2));
//        }
//
//        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
//        int lastParentIndex = array.length / 2 - 1;
//
//        // 左孩子
//        treeNodeList.get(lastParentIndex).setLeft(treeNodeList.get(lastParentIndex * 2 + 1));
//
//        // 右孩子,如果数组的长度为奇数才建立右孩子
//        if (array.length % 2 == 1) {
//            treeNodeList.get(lastParentIndex).setRight(treeNodeList.get(lastParentIndex * 2 + 2));
//        }
//
//        return treeNodeList;
//    }

//    private TreeNode buildBinTreeByPreSort(int[] preOrder, int index) {
//
//
//    }

//    public static void main(String[] args) {
//        NodeTotalNum nodeTotalNum = new NodeTotalNum();
//
//        // 层序遍历数组，构建二叉树
//        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8};
//        List<TreeNode> treeNodeList = nodeTotalNum.buildBinTreeByLevelOrder(array);
//        System.out.println(JSON.toJSONString(treeNodeList));
//
//        // 前序遍历数组(0表示无子节点)，构建二叉树
//        int[] preOrder = {1,2,3,0,4,5,0,0,6,0,0,7,0,0,8,0,9,10,0,0,0};
////        Node preRoot =
//
//
//
//
//
//
//
//
//    }
}
