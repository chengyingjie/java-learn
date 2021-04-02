package com.jesse.learn.algorithm.tmptmp;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class backtrackkuohao {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i-1] > nums[i]) continue;

            // 寻找比 nums[i-1] 稍微大点的数
            for (int j = nums.length - 1; j > i-1; j--) {
                if (nums[i-1] < nums[j]) {
                    int tmp = nums[i-1];
                    nums[i-1] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }

            Arrays.sort(nums, i, nums.length);
            break;
        }
    }
    public static void main(String[] args) {
        backtrackkuohao kuohao = new backtrackkuohao();
        char[][] grid = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        int[] nums = {1,2,3};
        kuohao.nextPermutation(nums);
        System.out.println(JSON.toJSONString(nums));
    }
}
