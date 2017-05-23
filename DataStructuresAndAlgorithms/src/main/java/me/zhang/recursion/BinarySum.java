package me.zhang.recursion;

/**
 * Created by zhangxiangdong on 2017/5/23.
 */
public class BinarySum {

    public long sumUp(int[] a, int low, int high) {
        if (low > high) {
            return 0;
        } else if (low == high) {
            return a[low];
        } else {
            int mid = (low + high) / 2;
            return sumUp(a, low, mid) + sumUp(a, mid + 1, high);
        }
    }

}
