package com.jesse.learn.algorithm.twopoint;

/**
 * 题意：反转一个单链表。
 *
 * 示例: 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinked {


    public static void main(String[] args) {


        BuildLinked buildLinked = new BuildLinked();
        int[] array = {1,2,3,4,5,6};
        // 头插法构建链表
//        LinkedNode nodeHead = buildLinked.buildLinkedByAddHead(array);
        // 尾插法构建链表
        LinkedNode nodeTail = buildLinked.buildLinkedByTail(array);
        // 指定位置插入元素
//        LinkedNode head = buildLinked.addNodeAtIndex(7, 4);

        // 反转链表
        ReverseLinked reverseLinked = new ReverseLinked();
        LinkedNode reverseNode = reverseLinked.reverseLinked(nodeTail);

        while (reverseNode != null) {
            System.out.print(reverseNode.getData());
            reverseNode = reverseNode.getNext();
        }
    }

    private LinkedNode reverseLinked(LinkedNode head) {
        LinkedNode cur = head, pre = null;
        while (cur != null) {
            LinkedNode tmp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }

        return pre;
    }




}
