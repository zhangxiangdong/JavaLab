package me.zhang.offer;

import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/9/14.
 * <p>
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出任意一对即可。
 * 例如，输入数组{1, 3, 6, 8, 9, 13}，数字14，输出[6, 8]或者[1, 13]
 */
public class Q41 {

    /**
     * 任意找出一对和为s的数字。
     * <p>
     * 一、使用两个索引，分别指向数组最左边和最右边的数。
     * 二、当两个索引指向的数的和小于目标s，则向右移动左边的索引；
     * 三、当两个索引指向的数的和大于目标s，则向左移动右边的索引；
     * 四、当左边的索引仍在右边索引左侧，重复以上操作，直至找到和为目标s的两个数。
     * <p>
     * 时间复杂度O(n)。
     *
     * @param a 递增数组
     * @param s 和
     * @return 任意一对数字
     */
    public static int[] findOutTwoNumbersEqualS(int[] a, int s) {
        validate(a);

        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int sum = a[lo] + a[hi];
            if (sum == s) {
                return new int[]{a[lo], a[hi]};
            } else if (sum < s) {
                lo++;
            } else {
                hi--;
            }
        }
        return null;
    }

    /**
     * 找出所有的和为s的连续序列。
     * 例如，输入9，输出[2, 3, 4]和[4, 5]
     *
     * @param s 和
     */
    public static void printOutAllContinuousSequences(int s) {
        int small = 1, big = 2;
        int middle = (1 + s) / 2;
        while (small < middle) {
            int sum = 0;
            for (int i = small; i <= big; i++) {
                sum += i;
            }
            if (sum == s) {
                print(small, big);
                big++;
            } else if (sum < s) {
                big++;
            } else {
                small++;
            }
        }
    }

    private static void print(int small, int big) {
        System.out.print("[");
        for (int i = small; i <= big; i++) {
            System.out.print(i + (i < big ? ", " : ""));
        }
        System.out.print("]");
    }

    private static void validate(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 8, 9, 13};
        int s = 14;
        System.out.println(s + ": " + Arrays.toString(findOutTwoNumbersEqualS(a, s)));
        s = 11;
        System.out.println(s + ": " + Arrays.toString(findOutTwoNumbersEqualS(a, s)));
        s = 5;
        System.out.println(s + ": " + Arrays.toString(findOutTwoNumbersEqualS(a, s)));

        s = 3;
        System.out.print(s + ": ");
        printOutAllContinuousSequences(s);
        System.out.println();

        s = 4;
        System.out.print(s + ": ");
        printOutAllContinuousSequences(s);
        System.out.println();

        s = 9;
        System.out.print(s + ": ");
        printOutAllContinuousSequences(s);
        System.out.println();
    }

}
