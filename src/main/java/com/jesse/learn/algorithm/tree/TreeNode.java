package com.jesse.learn.algorithm.tree;

import lombok.Data;

@Data
public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private String data;

    TreeNode(String data) {
        this.data = data;
    }
}
