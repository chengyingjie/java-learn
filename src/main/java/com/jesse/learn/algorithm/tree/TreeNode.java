package com.jesse.learn.algorithm.tree;

import lombok.Data;

@Data
public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private int data;

    TreeNode(int data) {
        this.data = data;
    }
}
