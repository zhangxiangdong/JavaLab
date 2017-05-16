package me.zhang.recursion;

/**
 * Created by zhangxiangdong on 2017/5/16.
 */
public class BinarySearch {

    public int recursion(int[] a, int target, int low, int high) {
        if (low > high) {
            return -1; // Not found.
        } else {
            int mid = (low + high) / 2;
            if (target == a[mid]) {
                return mid;
            } else if (target < a[mid]) {
                return recursion(a, target, low, mid - 1);
            } else {
                return recursion(a, target, mid + 1, high);
            }
        }
    }

    public int loop(int[] a, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == a[mid]) {
                return mid;
            } else if (target < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
