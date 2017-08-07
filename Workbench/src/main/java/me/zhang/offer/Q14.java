package me.zhang.offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个方法来调整改数组中数字的顺序，是的所有奇数位于数组的前半部分，
 * 所有偶数位于数组的后半部分。
 */
public class Q14 {

    public void reorderByOddAndEvenSlow(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if ((a[j] & 1) == 0 && (a[j + 1] & 1) == 1) {
                    // a[j]是偶数，a[j+1]是奇数，执行交换
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public void reorderByOddAndEvenFast(int[] a) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            while ((a[left] & 1) != 0) {
                left++;
            }
            while ((a[right] & 1) != 1) {
                right--;
            }

            if (left < right) {
                // a[left]是偶数，a[right]是奇数，执行交换
                swap(a, left, right);
            }
        }
    }

    private void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static void main(String[] args) {
        Q14 q14 = new Q14();
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        q14.reorderByOddAndEvenSlow(a);
        System.out.println(Arrays.toString(a));

        a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        q14.reorderByOddAndEvenFast(a);
        System.out.println(Arrays.toString(a));
    }

}
