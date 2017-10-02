package me.zhang.coreJava;

import java.util.Arrays;

/**
 * Created by Zhang on 10/2/2017 4:42 PM.
 */
public class ArrayTest {

    public static void main(String[] args) {
        /* 从1-49中随机抽取6个不同的数 */
        int n = 49, k = 6;
        int[] numbers = new int[n];
        int[] result = new int[k];

        // 1. 初始化要抽取的n个数
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        System.out.println(Arrays.toString(numbers));

        // 2. 共抽取k次
        for (int i = 0; i < k; i++) {
            int r = (int) (Math.random() * n);
            // 2.1 保存从n个数中随机抽到的数
            result[i] = numbers[r];
            // 2.2 将最后一个数覆盖到抽取到的位置，防止抽到重复的数
            numbers[r] = numbers[n - 1];
            // 2.3 缩小抽数的范围（在剩下的n-1个数中继续抽取）
            n--;
        }
        System.out.println(Arrays.toString(result));
    }

}
