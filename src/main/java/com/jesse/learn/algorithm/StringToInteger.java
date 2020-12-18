package com.jesse.learn.algorithm;

import org.apache.commons.lang3.StringUtils;

/**
 * 实现 atoi，将字符串转为整数。
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 *
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 *
 * 若函数不能执行有效的转换，返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 */
public class StringToInteger {

    private boolean isValidChar(char c) {
        return c == '+' || c == '-' || (c >= '0' && c <= '9');
    }

    private Integer strTransInt(String str) {

        // 找到第一个有效字符
        int startIndex = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                startIndex = i;
                break;
            }
        }

        if (startIndex == -1 || !isValidChar(str.charAt(startIndex))) {
            return 0;
        }

        long res = 0;
        int min = (int)(-Math.pow(2,31)), max = (int)(Math.pow(2,31) - 1);
        int sign = str.charAt(startIndex) == '-' ? -1 : 1;
        int digitIndex = (str.charAt(startIndex) == '-' || str.charAt(startIndex) == '+') ? startIndex + 1 : startIndex;
        for (int i = digitIndex; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }

            res = res * 10 + sign * (str.charAt(i) - '0');
            // 判断是否越界
            if (res < min) {
                return (int)(-Math.pow(2,31));
            } else if (res > max) {
                return (int)(Math.pow(2,31) - 1);
            }
        }

        return (int)res;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.strTransInt("9223372036854775808"));
        System.out.println(stringToInteger.strTransInt("-91283472332"));

    }

}
