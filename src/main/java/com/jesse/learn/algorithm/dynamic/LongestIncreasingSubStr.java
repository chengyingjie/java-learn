package com.jesse.learn.algorithm.dynamic;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * 求最长递增子串
 *
 * 思路：
 * （1）dp数组：以num[i]字符结尾的，且不含有重复字符的子串长度
 * （2）状态转移方程： if(num[i]>num[i-1]) dp[i]=dp[i-1]+1 else dp[i]=1
 * （3）base case: dp[0]=1
 */
public class LongestIncreasingSubStr {

    private int getLongestSubStrLength(String s) {
        if (StringUtils.isEmpty(s)) {
            return 0;
        }

        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(i-1)) {
                dp[i]=dp[i-1]+1;
            } else {
                dp[i]=1;
            }
        }

        int max = dp[0];
        for (int i = 1; i < s.length(); i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        String str = "099";
        StringBuffer sbuff = new StringBuffer(str);
        System.out.println(sbuff.reverse().toString());


        LongestIncreasingSubStr subStr = new LongestIncreasingSubStr();
        System.out.println(subStr.getLongestSubStrLength("cavdaabdecdefead"));
        System.out.println(subStr.getLongestSubStr("cavdaabdecdefead"));
    }

    private int getLongestSubStr(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(i-1)) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        // 取最大值
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
