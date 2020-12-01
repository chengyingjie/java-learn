package com.jesse.learn.algorithm.dynamic;

/**
 * 最小编辑距离
 *
 * 示例：
 * "kitten" 和 "sitting" 这两个单词，由 "kitten" 转换为 "sitting" 需要的最少单字符编辑操作有：
 * 1.kitten → sitten (substitution of "s" for "k")
 * 2.sitten → sittin (substitution of "i" for "e")
 * 3.sittin → sitting (insertion of "g" at the end)
 * 因此，"kitten" 和 "sitting" 这两个单词之间的编辑距离为 3 。
 *
 * 思路：
 * （1）dp数组：以s[i],m[j]结尾的字符串，最小编辑距离
 * （2）base case: dp[0][n]=n,dp[n][0]=n, n=0,1,...,n
 * （3）状态转移方程： if(s[i] == s[j]) dp[i][j]=dp[i-1][j-1] else dp[i][j]=min(dp[i][j-1],dp[i-1][j]) + 1
 */
public class BianJiJuLi {

    private int minEditLength(String s1, String s2) {

        // 初始化dp数组
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int index = 0; index <= s1.length(); index++) {
            dp[index][0] = index;
        }

        for (int index = 0; index <= s2.length(); index++) {
            dp[0][index] = index;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "abc", s2 = "cba";
        BianJiJuLi distance = new BianJiJuLi();
        System.out.println(distance.minEditLength(s1, s2));
    }

}
