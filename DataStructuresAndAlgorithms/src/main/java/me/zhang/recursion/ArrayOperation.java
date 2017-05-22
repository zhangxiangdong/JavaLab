package me.zhang.recursion;

/**
 * Created by zhangxiangdong on 2017/5/22.
 */
public class ArrayOperation {

    /**
     * Recursion
     *
     * @param a    Target array.
     * @param low  First index of array.
     * @param high Last index of array.
     */
    public void reverseArray(int[] a, int low, int high) {
        if (low < high) {
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            reverseArray(a, low + 1, high - 1);
        }
    }

    /**
     * Loop
     *
     * @param a Target array.
     */
    public void reverseArray(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = temp;
        }
    }

}
