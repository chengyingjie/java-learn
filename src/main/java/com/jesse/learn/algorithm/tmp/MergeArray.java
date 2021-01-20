package com.jesse.learn.algorithm.tmp;

import com.alibaba.fastjson.JSON;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class MergeArray {

    public void merge(int A[], int m, int B[], int n) {
        if (n <= 0) {
            return;
        }

        // 加长nums1数组长度，并做初始化
        for (int i = m; i < m+n; i++) {
            A[i] = 0;
        }

        // 双指针法：A、B两个数组，从后往前遍历
        int index= m + n - 1, i = m -1, j = n - 1;
        while (index >= 0) {
            if (j < 0) {
                A[index] = A[i--];
            } else if (i < 0) {
                A[index] = B[j--];
            } else if (A[i] > B[j]) {
                A[index] = A[i--];
            } else {
                A[index] = B[j--];
            }

            index--;
        }
    }

    public static void main(String[] args) {
        MergeArray mergeArray = new MergeArray();
        int[] A = {1,2,3,0,0,0}, B = {2,5,6};
        mergeArray.merge(A, 3, B, B.length);
        System.out.println(JSON.toJSONString(A));
    }
}
