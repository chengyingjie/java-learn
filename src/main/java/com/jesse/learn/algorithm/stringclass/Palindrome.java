package com.jesse.learn.algorithm.stringclass;

/**
 * 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xah8k6/
 */
public class Palindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        StringBuilder sbuff = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sbuff.append((char)c);
            } else if (c >= 'A' && c <= 'Z') {
                sbuff.append((char)(c + 'a' - 'A'));
            }
        }

//        if (sbuff.toString().equals(sbuff.reverse().toString())) {
//            return true;
//        }

        // 双指针法
        int i = 0, j = sbuff.toString().length() - 1;
        while (i < j) {
            if (sbuff.charAt(i++) != sbuff.charAt(j--)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
