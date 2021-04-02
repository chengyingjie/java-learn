package com.jesse.learn.algorithm;

import java.util.ArrayList;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 思路：
 *
 */
public class DigitReverse {

    private int getReverseInt(int val) {
        if (val == 0) return 0;

        int valCopy = Math.abs(val);
        boolean negative = val < 0;

        long res = 0L;
        while (valCopy > 0) {
            res = res*10 + valCopy % 10;
            valCopy = valCopy / 10;
        }

        res = negative ? -res : res;
        if (res < -Math.pow(2, 31) || res > Math.pow(2, 31) -1) {
            return 0;
        }

        return (int) res;
    }

    public static void main(String[] args) {
        DigitReverse digitReverse = new DigitReverse();
        int[] arr1 = {9}, arr2 = {6};
//        System.out.println(digitReverse.addInList(head1, head2));
    }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        ListNode head = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            head = mergeNode(head, lists.get(i));
        }

        return head;
    }

    private ListNode mergeNode(ListNode left, ListNode right) {
        ListNode res = new ListNode(0), head = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = new ListNode(left.val);
            } else {
                head.next = new ListNode(right.val);
            }

            head = head.next;
            left = left.next;
            right = right.next;
        }

        head.next = left != null ? left : right;

        return res.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
