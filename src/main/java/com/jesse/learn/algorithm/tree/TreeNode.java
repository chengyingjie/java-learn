package com.jesse.learn.algorithm.tree;

import lombok.Data;

@Data
public class Node {

    private Node left;
    private Node right;
    private int data;

    Node(int data) {
        this.data = data;
    }
}
