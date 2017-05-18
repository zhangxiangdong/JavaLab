package me.zhang.recursion;

import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/5/18.
 */
public class LinearSum {

    public int sumUp(int[] a, int n) {
        if (n == 0) {
            return 0;
        }
        return sumUp(a, n - 1) + a[n - 1];
    }

    public static void main(String[] args) {
        LinearSum sum = new LinearSum();
        final int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // (n + 1) * n / 2
        System.out.println(Arrays.toString(a) + ": " + sum.sumUp(a, a.length));
    }

}
