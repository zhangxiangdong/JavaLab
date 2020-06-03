package me.zhang.offer;

import java.util.Arrays;

/**
 * Created by Zhang on 9/2/2017 9:15 AM.
 * <p>
 * 在数组中的两个数字如果前面一个数大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 * <p>
 * 例如，在数组{7, 5, 6, 4}中，一共存在5个逆序对，分别是(7, 6)、(7, 5)、(7, 4)、(6, 4)和(5, 4)。
 */
public class Q36 {

    /**
     * 按顺序扫描整个数组。每扫到一个数字的时候，逐个比较该数字和它后面的数字的大小。
     * 如果比后面的数字大，则这两个数就组成一个逆序对。
     * 时间复杂度：O(n^2)。
     *
     * @param a 要扫描的数组
     * @return 逆序对个数
     */
    public static int inversePairs(int[] a) {
        validateInput(a);

        int count = 0;
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int left = a[i];
                int right = a[j];
                if (left > right) {
                    count++;
                    System.out.printf("(%d, %d)\n", left, right);
                }
            }
        }
        return count;
    }

    public static int inverseParisEfficiently(int[] a) {
        validateInput(a);

        int len = a.length;
        int[] temp = new int[len];
        return inversePairsCore(a, temp, 0, len - 1);
    }

    private static int inversePairsCore(int[] data, int[] temp, int start, int end) {
        int inversions = 0;
        if (start < end) {
            int mid = (end + start) / 2;
            // 查找左半段的逆序对数目
            int left = inversePairsCore(data, temp, start, mid);
            // 查找有半段的逆序对数目
            int right = inversePairsCore(data, temp, mid + 1, end);
            // 查找完左右半段逆序对以后两段数组有序，然后查两段之间的逆序对。最小的逆序段只有一个元素。
            int count = merge(data, temp, start, mid, end);
            inversions = left + right + count;
        }
        return inversions;
    }

    private static int merge(int[] data, int[] temp, int start, int mid, int end) {
        int i = mid;
        int j = end;
        int indexCopy = 0;
        int count = 0;
        while (i >= start && j > mid) {
            if (data[i] > data[j]) {
                temp[indexCopy++] = data[i--];
                // 因为data[mid + 1...j...end]是有序的，如果data[i] > data[j]，那么也大于data[j]之前的元素。
                // 从mid + 1...j一共有j - (mid + 1) + 1 = j - mid个逆序对。
                count += j - mid;
            } else {
                temp[indexCopy++] = data[j--];
            }
        }

        while (i >= start) {
            temp[indexCopy++] = data[i--];
        }

        while (j > mid) {
            temp[indexCopy++] = data[j--];
        }

        for (i = 0; i < indexCopy; i++) {
            data[end - i] = temp[i];
        }

        print(data);
        print(temp);
        System.out.println("******************");
        return count;
    }

    private static void print(int[] data) {
        System.out.println(Arrays.toString(data));
    }

    private static void validateInput(int[] a) {
        if (a == null) {
            throw new NullPointerException("输入的数组不能为null");
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 5, 6, 4};
        int count = inversePairs(a);
        System.out.println("Number of inversed pairs: " + count);

        count = inverseParisEfficiently(a);
        System.out.println("Number of inversed pairs(Efficiently): " + count);
    }

}
