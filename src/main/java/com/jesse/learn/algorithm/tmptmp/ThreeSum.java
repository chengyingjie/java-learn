package com.jesse.learn.algorithm.tmptmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j-1] == nums[j]) {
                    continue;
                }

                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k-1] == nums[k]) {
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> numArr = new ArrayList<>();
                        numArr.add(nums[i]);
                        numArr.add(nums[j]);
                        numArr.add(nums[k]);
                        res.add(numArr);
                    }
                }
            }
        }

        return res;
    }

//    public static void main(String[] args) {
//        int[] arr = {-1,0,1,2,-1,-4};
//        ThreeSum threeSum = new ThreeSum();
//        System.out.println(threeSum.threeSum(arr));
//    }

    public static void main(String[] args) {
        List<String> stack = new ArrayList<>();
        stack.add("1");
        stack.add("2");
        System.out.println(stack.toString());
    }
}
