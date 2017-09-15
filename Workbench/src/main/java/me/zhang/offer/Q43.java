package me.zhang.offer;

import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/9/15.
 * <p>
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 */
public class Q43 {
    private static final int MAX_VALUE = 6;

    public static void printProbability(int number) {
        if (number < 1) {
            throw new IllegalArgumentException();
        }

        int maxSum = number * MAX_VALUE;
        // 存储所有可能出现的每个s的次数
        int[] probabilities = new int[maxSum - number + 1];

        // 获取所有可能的每个s出现的次数
        probability(number, probabilities);
        System.out.println(Arrays.toString(probabilities));

        // number个骰子所有的可能组合
        int total = (int) Math.pow(MAX_VALUE, number);
        for (int i = number; i <= maxSum; i++) {
            double ratio = (double) probabilities[i - number] / total;
            System.out.printf("%d: %e\n", i, ratio);
        }
    }

    private static void probability(int number, int[] probabilities) {
        for (int i = 1; i <= MAX_VALUE; i++) {
            probability(number, number, i, probabilities);
        }
    }

    private static void probability(int original, int current, int sum, int[] probabilities) {
        if (current == 1) {
            probabilities[sum - original]++;
        } else {
            for (int i = 1; i <= MAX_VALUE; i++) {
                probability(original, current - 1, i + sum, probabilities);
            }
        }
    }

    public static void main(String[] args) {
        printProbability(3);
    }

}
