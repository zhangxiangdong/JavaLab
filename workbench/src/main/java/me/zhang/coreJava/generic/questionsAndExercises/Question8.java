package me.zhang.coreJava.generic.questionsAndExercises;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangxiangdong on 2017/11/16.
 * <p>
 * Write a generic method to find the maximal element in the range [begin, end) of a list.
 */
public class Question8 {

    public static <E extends Comparable> Comparable max(List<E> list, int begin, int end) {
        if (list == null) {
            throw new NullPointerException();
        }

        final int size = list.size();
        if (size == 0) {
            throw new IllegalArgumentException();
        }

        final int head = 0;
        final int tail = list.size() - 1;
        if ((begin < head || end < head) || (begin > tail || end > tail) || (begin > end)) {
            throw new IllegalArgumentException();
        }

        E max = list.get(begin);
        for (int i = begin; i < end; i++) {
            E e = list.get(i);
            if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 8, 6, 5, 4, 7, 3, 9, 0);
        System.out.println(max(integers, 3, 5)); // 6
    }

}