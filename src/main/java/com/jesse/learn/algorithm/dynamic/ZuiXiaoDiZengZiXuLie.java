package com.jesse.learn.algorithm.dynamic;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 最大递增子序列长度
 *
 * 思路：
 * （1）dp数组：一维的，dp[n]表示 n长度的字符串最大子序列长度
 * （2）状态转移方程：if(s[j] > max(dp[1],...,dp[j-1])中最大值) dp[j]=max(dp[1],...,dp[j-1]) + 1 else dp[j]=max(dp[1],...,dp[j-1])
 * （3）base case: dp[0]=0,dp[1]=1
 */
public class ZuiXiaoDiZengZiXuLie {

    private int minIncreaseSubSequence(String s1) {

        int[] dp = new int[s1.length()+1];
        dp[0] = 0;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i] = 1;
        }

        for (int i = 2; i <= s1.length(); i++) {
            int max = 1;
            for (int j = 1; j < i; j++) {
                if (s1.charAt(i-1) > s1.charAt(j-1)) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        System.out.println(JSON.toJSONString(dp));
        return dp[s1.length()];
    }

    public static void main(String[] args) {
        ZuiXiaoDiZengZiXuLie sequence = new ZuiXiaoDiZengZiXuLie();
        System.out.println(sequence.minIncreaseSubSequence("aeefagbade"));

    }
}
