package me.zhang.sort;

/**
 * Created by zhangxiangdong on 2017/4/28.
 * <p>
 * We start with the first element in the array, which is trivially sorted by itself. When
 * considering the next element in the array, if it is smaller than the first, we swap
 * them. Next we consider the third element in the array, swapping it leftward until it
 * is in its proper order relative to the first two elements. We continue in this manner
 * with the fourth element, the fifth, and so on, until the whole array is sorted.
 */
public class InsertionSort {

    public void sort(int[] A) {
        int len = A.length;
        int out, in;
        for (out = 1; out < len; out++) {
            int temp = A[out];
            for (in = out; in > 0; in--) {
                if (A[in - 1] < temp) {
                    break;
                } else {
                    A[in] = A[in - 1];
                }
            }
            A[in] = temp;
        }
    }

    public static void main(String[] args) {
        InsertionSort sort = new InsertionSort();
        int[] A = {3, 2, 5, 4, 7, 6, 9, 0, 8, 1};
        printOutArray(A);
        sort.sort(A);
        printOutArray(A);
    }

    private static void printOutArray(int[] A) {
        for (int a : A) {
            System.out.print(" " + a);
        }
        System.out.println();
    }

}
