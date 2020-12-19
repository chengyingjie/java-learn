package com.jesse.learn.algorithm.twopoint;


/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并「原地」修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 「你不需要考虑数组中超出新长度后面的元素。」
 */
public class RemoveElement {


    // 暴力求解法
    private int removeEleByBaoli(int[] array, int val) {

        int size = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == val) {
                for (int j = i+1; j < array.length; j++) {
                    array[j-1] = array[j];
                }

                i--;
                size++;
            }
        }

        return array.length - size;
    }

    // 「双指针法（快慢指针法）在数组和链表的操作中是非常常见的，很多考察数组和链表操作的面试题，都使用双指针法。」
    private int removeEleByTwoPoint(int[] array, int val) {
        int slowIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != val) {
                array[slowIndex++] = array[i];
            }
        }

        return slowIndex;
    }

    public static void main(String[] args) {
//        int[] array = {0,1,2,2,3,0,4,2};
        int[] array = {3,2,2,3};
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeEleByBaoli(array,2));

        int[] array1 = {3,2,2,3};
        System.out.println(removeElement.removeEleByTwoPoint(array1, 2));
    }






}
