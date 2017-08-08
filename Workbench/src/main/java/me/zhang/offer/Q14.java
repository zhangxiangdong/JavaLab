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

    /**
     * @param a    要分组的数组
     * @param func 策略。比如：按照大小分为两部分，所有负数都在非负数前面；能被3整除的数都在不能被3整除的前面。
     */
    public void group(int[] a, Func func) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            while (!func.calc(a[left])) {
                left++;
            }
            while (left < right && func.calc(a[right])) {
                right--;
            }

            if (left < right) {
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
        // 策略模式（Strategy Pattern）
        q14.group(a, new IsEven());
        System.out.println(Arrays.toString(a));
    }

    static class IsEven implements Func {
        @Override
        public boolean calc(int i) {
            return isEven(i);
        }

        private boolean isEven(int i) {
            return (i & 1) == 0;
        }
    }

    interface Func {
        boolean calc(int i);
    }

}
