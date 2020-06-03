package me.zhang.offer;

import java.util.Arrays;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或者连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * 例如：输入的数组为{1, -2, 3, 10, -4, 7, 2, -5}，和最大的子数组为{3, 10, -4, 7, 2}，因此输出为该子数组的和为18。
 */
public class Q31 {

    public int findGreatestSumOfSubArray(int[] input) {
        if (input == null) {
            throw new NullPointerException("输入数组不能为null");
        }

        int currentSum = 0;
        int greatestSum = 0;
        // 记录子数组的起始和结束索引
        int start = 0, end = 0;
        for (int i = 0; i < input.length; i++) {
            // 当前累加的和不为正数，则舍弃
            if (currentSum <= 0) {
                currentSum = input[i];
                start = i;
            } else {
                // 累加下一个数字
                currentSum += input[i];
            }
            // 累加后的当前和大于之前保存的最大累加和
            if (currentSum > greatestSum) {
                greatestSum = currentSum;
                end = i;
            } else {
                end = i - 1;
            }
        }
        // 输出最大和的子数组
        int[] subArray = new int[end - start + 1];
        System.arraycopy(input, start, subArray, 0, subArray.length);
        System.out.println(Arrays.toString(subArray));
        return greatestSum;
    }

    public static void main(String[] args) {
        Q31 q31 = new Q31();
        int[] input = {1, -2, 3, 10, -4, 7, 2, -5};
        int greatestSum = q31.findGreatestSumOfSubArray(input);
        System.out.println("Greatest Sum of SubArray: " + greatestSum);
    }

}
