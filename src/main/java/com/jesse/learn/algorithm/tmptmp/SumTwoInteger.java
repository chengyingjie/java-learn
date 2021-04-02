package com.jesse.learn.algorithm.tmptmp;

import com.alibaba.fastjson.JSON;

public class SumTwoInteger {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int l1Size = getListNodeLen(l1), l2Size = getListNodeLen(l2);
        if (l1Size <= l2Size) {
            return calculateListNodeSize(l1, l2);
        }

        return calculateListNodeSize(l2, l1);
    }

    private int getListNodeLen(ListNode l) {
        ListNode tmpNode = l;
        int len = tmpNode == null ? 0 : 1;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            ++len;
        }

        return len;
    }

    // 两数相加方法
    private ListNode calculateListNodeSize(ListNode minNode, ListNode maxNode) {
        int val = maxNode.val + minNode.val;
        int flag = val / 10; // 用于标识要进的的位

        ListNode res = new ListNode(val%10, null);
        ListNode head = res;
        while (minNode.next != null) {
            minNode = minNode.next;
            maxNode = maxNode.next;
            int tmpVal = maxNode.val + minNode.val + flag;
            flag = tmpVal / 10;
            res.next = new ListNode(tmpVal%10, null);
            res = res.next;
        }

        while (maxNode.next != null) {
            maxNode = maxNode.next;
            int tmpVal = maxNode.val + flag;
            flag = tmpVal / 10;
            res.next = new ListNode(tmpVal%10, null);
            res = res.next;
        }

        if (flag > 0) {
            res.next = new ListNode(flag, null);
        }

        return head;
    }

    public static void main(String[] args) {
        int[] l1 = {0,8,6,5,6,8,3,5,7}, l2 = {6,7,8,0,8,5,8,9,7};
        SumTwoInteger sumTwoInteger = new SumTwoInteger();
        ListNode res = sumTwoInteger.addTwoNumbers(sumTwoInteger.buildNodeByTail(l1), sumTwoInteger.buildNodeByTail(l2));
        System.out.println(JSON.toJSONString(res));
    }

    public ListNode buildNodeByTail(int[] arr) {
        ListNode node = new ListNode(arr[0], null);
        ListNode head = node;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i], null);
            node = node.next;
        }

        return head;
    }


}
