package com.jesse.learn.algorithm.twopoint;


/**
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 *
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class ReverseKStr {

    private String assembleStr(char[] s, int start, int end) {
        StringBuffer str = new StringBuffer();
        for (int i = start; i < end; i++) {
            str.append(s[i]);
        }

        return str.toString();
    }

    private String assembleReverseStr(char[] s, int start, int end) {
        StringBuffer str = new StringBuffer();
        for (int i = end-1; i >= start; i--) {
            str.append(s[i]);
        }

        return str.toString();
    }

    private String reverseKStr(char[] s, int k) {
        if (s == null || s.length < k) {
            return assembleStr(s, 0, s.length);
        }

        int index = 0;
        StringBuffer sbuff = new StringBuffer();
        while (index < s.length) {
            sbuff.append(assembleReverseStr(s, index, index + k));
            int endIndex = Math.min(index + k * 2, s.length);
            sbuff.append(assembleStr(s, index + k, endIndex));
            index = endIndex;
        }

        return sbuff.toString();
    }

    public static void main(String[] args) {
        ReverseKStr reverseKStr = new ReverseKStr();
        char[] c = {'a','b','c','d','e','f','g'};
        System.out.println(reverseKStr.reverseKStr(c, 2));
    }

}
