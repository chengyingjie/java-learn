package com.jesse.learn.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 *
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         结果.append(路径)
 *         return
 *     for 选择 in 选择列表:    # 核心代码段
 *         做出选择
 *         递归执行backtrack
 *         撤销选择
 */
public class QuanPaiLie {

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length <= 0) {
            return new ArrayList<>();
        }

        // 回溯算法求解
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrace(nums, track, res);

        return res;
    }

    private void backtrace(int[] nums, List<Integer> track, List<List<Integer>> res) {
        // 结束条件
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        // 选择条件
        for (int i = 0; i < nums.length; i++) {
            // 过滤已做的选择
            if (track.contains(nums[i])) {
                continue;
            }

            track.add(nums[i]);
            backtrace(nums, track, res);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        QuanPaiLie quanPaiLie = new QuanPaiLie();
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> res = quanPaiLie.permute(arr);
        System.out.println(res);
    }
}


