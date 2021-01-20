package com.jesse.learn.algorithm.tmp;

/**
 * 题目描述
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 * 示例1
 * 输入
 * 复制
 * [2,3,4,5]
 * 返回值
 * 复制
 * 4
 * 示例2
 * 输入
 * 复制
 * [2,2,3,4,3]
 * 返回值
 * 复制
 * 3
 * 备注:
 * 1 \leq n \leq 10^51≤n≤10
 * 5
 */
public class LongestSubStr {

    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {

        if (arr == null || arr.length <= 0) {
            return 0;
        }

        // 初始化数组
        int[] dp = new int[arr.length];

        // 基准条件
        dp[0] = 1;

        // 动态转移
        for (int i = 1; i < arr.length; i++) {
            // 往前遍历，找到第一个重复的元素
            dp[i] = 1;
            for (int j = i-1; j >= i - dp[i-1]; j--) {
                if (arr[i] == arr[j]) {
                    break;
                }
                dp[i]++;
            }
        }

        // 遍历寻找最大size
        int maxlen = dp[0];
        for (int i = 1; i < dp.length; i++) {
            maxlen = Math.max(maxlen, dp[i]);
        }

        return maxlen;
    }

    public static void main(String[] args) {
        LongestSubStr subStr = new LongestSubStr();
        int[] arr = {2,2,3,4,3};
        System.out.println(subStr.maxLength(arr));
    }
}
