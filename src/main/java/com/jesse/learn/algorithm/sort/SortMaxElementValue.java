package com.jesse.learn.algorithm.sort;

/**
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 *
 * 示例 2:
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 */
public class SortMaxElementValue {

    private Integer calculateMaxLen(Integer[] originInts) {
        // 数组元素个数小于2，直接返回
        if (originInts == null || originInts.length < 2) {
            return 0;
        }

        // 冒泡排序（从小到大）
        for (int i = 0; i < originInts.length - 1; i++) {
            for (int j = 0; j < originInts.length - 1 - i; j++) {
                if (originInts[j] > originInts[j+1]) {
                    int tmp = originInts[j];
                    originInts[j] = originInts[j+1];
                    originInts[j+1] = tmp;
                }
            }
        }

        // 遍历排序后的数组，取最大差值
        int max = originInts[1] - originInts[0];
        for (int i = 1; i < originInts.length - 1; i++) {
            max = Math.max(max, originInts[i+1] - originInts[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        SortMaxElementValue sortMaxElementValue = new SortMaxElementValue();
        System.out.println(sortMaxElementValue.calculateMaxLen(new Integer[]{3,2,9,1}));
    }
}
