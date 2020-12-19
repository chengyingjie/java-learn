package com.jesse.learn.algorithm.twopoint;


/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace {

    private String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                s = s + "  ";
            }
        }

//        for (int i = len-1, j = s.length()-1; i >= 0; i--,j--) {
//            if (s.charAt(i) == ' ') {
//                s.codePointAt(j) = (char)'0';
//                s.charAt(j) = (char)'2';
//                s.charAt(j) = (char)'%';
//            }
//        }

        return s;

    }



}
