package com.jesse.learn.algorithm.twopoint;


/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class Shuitongrongliang {

    // 双指针法求解
    private Integer maxArea(int[] height) {

        if (height == null || height.length <= 1) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxArea = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
        }

        return maxArea;
    }

    // 暴力求解
    private Integer getMaxArea(int[] height) {

        int max = -1;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (max < area) {
                    max = area;
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {

        int[] height = {3,1,4,6,9,12,2,3,1,4,5};
//        int[] height = {1,8,6,2,5,4,8,3,7};

        Shuitongrongliang shuitong = new Shuitongrongliang();
        System.out.println(shuitong.getMaxArea(height));
        System.out.println(shuitong.maxArea(height));
    }
}
