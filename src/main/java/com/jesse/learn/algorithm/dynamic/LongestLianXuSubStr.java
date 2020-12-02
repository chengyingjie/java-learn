package com.jesse.learn.algorithm.dynamic;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度
 *
 * 思路：
 * （1）dp数组：以num[i]字符结尾的，且不含有重复字符的子串长度
 * （2）状态转移方程：num[i]和dp[i-1]构成的子串无重复字符，则dp[i]=dp[i-1]+1；否则，找到dp[i-1]中重复字符的位置j，dp[i]=i-j
 * （3）base case: dp[0]=1
 */
public class LongestLianXuSubStr {

    private int getLongestSubStrLength(String s) {
        if (StringUtils.isEmpty(s)) {
            return 0;
        }

        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < s.length(); i++) {
            int index = i;
            for (int j = i-1; j>=0; j--) {
                if (s.charAt(j) == s.charAt(i)) {
                    index = j;
                    break;
                }
            }
            if (index == i) {
                dp[i] = dp[i-1] + 1;
            } else {
                if (i - index > dp[i-1]) {
                    dp[i] = dp[i-1] + 1;
                } else {
                    dp[i] = i-index;
                }
            }
        }

        int max = dp[0];
        for (int i = 1; i < s.length(); i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestLianXuSubStr subStr = new LongestLianXuSubStr();
        System.out.println(subStr.getLongestSubStrLength("acsaeedaxcvsfsb"));
    }
}
