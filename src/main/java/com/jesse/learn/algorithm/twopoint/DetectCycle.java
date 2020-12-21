package com.jesse.learn.algorithm.twopoint;

/**
 * 题意：给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *
 * 如果 pos 是 -1，则在该链表中没有环。
 *
 * 「说明」：不允许修改给定的链表。
 *
 */
public class DetectCycle {

    private int getCyclePos(LinkedNode head) {

        LinkedNode slow = head, fast = head;
        while (slow != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            // x = (n-1)(y+z) = z
            if (slow == fast) {
                slow = head;
                int pos = 0;
                while (slow != null && fast != null) {
                    if (slow == fast) {
                        return pos;
                    }

                    pos++;
                    slow = slow.getNext();
                    fast = fast.getNext();
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int pos = 3;
        BuildLinked linked = new BuildLinked();
        LinkedNode head = linked.buildCycleLinked(array, pos);

        DetectCycle detectCycle = new DetectCycle();
        System.out.println(detectCycle.getCyclePos(head));
    }


}
