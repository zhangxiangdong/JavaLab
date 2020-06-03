package me.zhang.dsa;

/**
 * Created by Zhang on 8/27/2017 12:05 PM.
 */
public class Util {

    public static int partition(int[] a, int lo, int hi) {
        int pivot = a[lo];
        int i = lo, j = hi;
        while (true) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

}
