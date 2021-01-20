package com.jesse.learn.algorithm.sort;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串，将字符串里面的字符按照出现的频率降序排列。
 * 例1：输入：“cbbaaa”，输出：“aaabbc”
 * 例2：输入：“cccaa”，输出：“cccaa”
 * 例3：输入：“aaAAA”，输出：“AAAaa”
 *
 * 思路：本质上就是字符个数的倒序排
 * （1）存map，统计每个字符出现的个数
 * （2）构建str数组
 * （3）对str数组进行排序
 */
public class StatTotalSort {

    private String getSortStr(String originStr) {

        // 存map，统计每个字符出现的个数
        Map<String, String> originStrMap = new HashMap<>();
        for (int i = 0; i < originStr.length(); i++) {
            String charStr = originStr.charAt(i) + "";
            if (originStrMap.containsKey(charStr)) {
                originStrMap.put(charStr, originStrMap.get(charStr) + charStr);
            } else {
                originStrMap.put(charStr, charStr);
            }
        }

        // 构建str数组
        String[] newStrArray = new String[originStrMap.values().size()];
        originStrMap.values().toArray(newStrArray);


        // 对str数组进行排序
        for (int i = 0; i < newStrArray.length - 1; i++) {
            for (int j = 0; j < newStrArray.length - 1 - i; j++) {
                if (newStrArray[j].length() < newStrArray[j+1].length()) {
                    String tmp = newStrArray[j];
                    newStrArray[j] = newStrArray[j+1];
                    newStrArray[j+1] = tmp;
                }
            }
        }

        // 输出结果
        String result = "";
        for (String str : newStrArray) {
            result += str;
        }

        return result;
    }

    public static void main(String[] args) {
        StatTotalSort statTotalSort = new StatTotalSort();
        System.out.println(statTotalSort.getSortStr("aaAAA"));
    }

}
