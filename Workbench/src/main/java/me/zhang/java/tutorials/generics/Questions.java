package me.zhang.java.tutorials.generics;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by zhangxiangdong on 2018/10/26 9:44.
 */
public class Questions {

    public static void main(String[] args) {
        testCount();
        testExchange();
        testMaximalInRange();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static void testCount() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            integers.add(i);
        }
        int numberOfOddNumbers = count(integers, t -> t % 2 != 0);
        System.out.println(numberOfOddNumbers);
    }

    private static void testExchange() {
        Integer[] ia = new Integer[10];
        for (int i = 0; i < 10; i++) {
            ia[i] = i;
        }
        System.out.println(Arrays.toString(ia));
        exchange(ia, 2, 8);
        System.out.println(Arrays.toString(ia));
    }

    private static void testMaximalInRange() {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add((int) (Math.random() * 100));
        }
        System.out.println(integers);
        Integer maximalInteger = maximalInRange(integers, 2, 8);
        System.out.println(maximalInteger);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private static <T extends Number> int count(@NotNull List<T> numbers, @NotNull Predicate<T> predicate) {
        int count = 0;
        for (T n : numbers) {
            if (predicate.test(n)) {
                count++;
            }
        }
        return count;
    }

    private static <T> void exchange(@NotNull T[] arr, int x, int y) {
        // Assume x and y are both legal.
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    @NotNull
    private static <T extends Comparable<T>> T maximalInRange(@NotNull List<T> source, int begin /* Inclusive */, int end /* Exclusive */) {
        // Assume both begin and end are valid.
        T maximum = source.get(begin);
        for (int i = begin + 1; i < end; i++) {
            T candidate = source.get(i);
            if (candidate.compareTo(maximum) > 0) {
                maximum = candidate;
            }
        }
        return maximum;
    }

}
