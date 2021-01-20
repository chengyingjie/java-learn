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
 * （3）状态转移方程（前提：i>0,j>0）：
 *   1）s[i],m[j]相等时，dp[i][j] = dp[i-1][j-1]
 *   2) s[i],m[j]不相等时，可以采用修改、新增、删除三种手段
 *   2.1）修改的方式，dp[i][j] = dp[i-1][j-1] + 1
 *   2.2）新增的方式，s[i]结尾添加m[j]字符，此时操作次数加1，dp[i][j] = dp[i][j-1] + 1
 *   2.3）新增的方式，m[j]结尾添加s[i]字符，此时操作次数加1，dp[i][j] = dp[i-1][j] + 1
 *   2.4）删除的方式，s[i]位置的字符删除掉，s和m都是以空字符结尾，此时操作次数加1，dp[i][j] = dp[i-1][j] + 1
 *   2.5）删除的方式，m[j]位置的字符删除掉，s和m都是以空字符结尾，此时操作次数加1，dp[i][j] = dp[i][j-1] + 1
 */
public class BianJiJuLi {

    private int minEditLength(String s1, String s2) {

        if (s1 == null || s1.equals("")) {
            return (s2 == null || s2.equals("")) ? 0 : s2.length();
        }

        if (s2 == null || s2.equals("")) {
            return s1.length();
        }

        // 定义dp数组
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        // 基准条件初始化
        for (int i = 0; i < s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < s2.length(); j++) {
            dp[0][j] = j;
        }

        // 状态转移
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                }
            }
        }

        // 结果返回
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "kitten", s2 = "sitting";
        BianJiJuLi distance = new BianJiJuLi();
        System.out.println(distance.minEditLength(s1, s2));
    }

}
