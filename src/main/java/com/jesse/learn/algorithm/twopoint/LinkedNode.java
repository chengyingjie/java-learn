package com.jesse.learn.algorithm.twopoint;

import lombok.Data;

@Data
public class LinkedNode {

    private int data;
    private LinkedNode next;

    LinkedNode(int data) {
        this.data = data;
    }
}
