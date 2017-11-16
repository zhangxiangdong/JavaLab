package me.zhang.coreJava.generic.questionsAndExercises;

import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/11/16.
 * <p>
 * Write a generic method to exchange the positions of two different elements in an array.
 */
public class Question3 {

    public static <E> void swap(E[] a, int first, int second) {
        if (a == null) {
            throw new NullPointerException();
        }

        int len = a.length;
        if (len == 0) {
            throw new IllegalArgumentException();
        }

        final int head = 0;
        final int tail = len - 1;
        if ((first < head || second < head) || (first > tail || second > tail)) {
            throw new IllegalArgumentException();
        }

        E temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(a));
        swap(a, 2, 3);
        System.out.println(Arrays.toString(a));
    }

}
