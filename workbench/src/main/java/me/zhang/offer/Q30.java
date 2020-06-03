package me.zhang.offer;

import me.zhang.dsa.AutoSortArrayList;
import me.zhang.dsa.AutoSortList;

import java.util.Arrays;

import static me.zhang.dsa.Util.partition;

/**
 * Created by Zhang on 8/27/2017 11:34 AM.
 * <p>
 * 输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Q30 {

    public int[] getLeastNumbers(int[] input, int k) {
        validateInput(input, k);

        Arrays.sort(input);
        int[] result = new int[k];
        System.arraycopy(input, 0, result, 0, k);
        return result;
    }

    private void validateInput(int[] input, int k) {
        if (input == null) {
            throw new NullPointerException("输入的数组不能为null");
        }
        if (input.length < k) {
            throw new IllegalArgumentException("输入的数组长度为" + input.length + "，而要寻找最小的" + k + "个数");
        }
    }

    /**
     * 基于数组的第n个数字来调整，使得比第n个数字小的左右数字都位于数组的左边，
     * 比第n个数字大的所有数字都位于数组的右边。这样调整之后，位于数组中左边的n个数字就是最小的n个数字（这n个数字不一定是排序的）。
     * 优点：速度快 O(n)；缺点：需要修改原始数组。
     *
     * @param input 要查找的数组
     * @param k     要查找的最小的数的个数
     * @return int[] 最小的n个数
     */
    public int[] getLeastNumbersWithPartition(int[] input, int k) {
        validateInput(input, k);

        int start = 0, end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            } else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }
        int[] result = new int[k];
        System.arraycopy(input, 0, result, 0, k);
        return result;
    }

    /**
     * 借助集合框架保存最小的n个数。优点：不需要修改原始数组；缺点：较慢 O(nlogk)。
     */
    public int[] getLeastNumbersWithAutoSortedContainer(int[] input, int k) {
        AutoSortList<Integer> container = new AutoSortArrayList<>();
        for (int i : input) {
            if (container.size() < k) {
                container.add(i);
            } else {
                if (container.last() > i) {
                    container.pollLast();
                    container.add(i);
                }
            }
        }
        int[] result = new int[k];
        int index = 0;
        for (int i : container) {
            result[index++] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {2, 1, 3, 4, 8, 6, 7, 5, 9};
        Q30 q30 = new Q30();
        System.out.println(Arrays.toString(q30.getLeastNumbers(input, 3)));

        try {
            q30.getLeastNumbers(null, 1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            q30.getLeastNumbers(new int[]{3, 2, 1}, 4);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println(Arrays.toString(q30.getLeastNumbersWithPartition(input, 5)));

        System.out.println(Arrays.toString(q30.getLeastNumbersWithAutoSortedContainer(input, 4)));
    }

}
