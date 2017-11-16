package me.zhang.coreJava.generic.questionsAndExercises;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangxiangdong on 2017/11/16.
 * <p>
 * Write a generic method to count the number of elements in a collection that have a specific property
 * (for example, odd integers, prime numbers, palindromes).
 */
public class Question1 {

    public static <E> int count(List<E> numbers, Strategy<E> strategy) {
        int count = 0;
        for (E i : numbers) {
            if (strategy.isTarget(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), i -> i % 2 != 0)); // 5 odds
        System.out.println(count(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), i -> {
            boolean isPrime = true;
            for (int j = 1; j < i / 2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            return isPrime;
        })); // 3 primes
    }

}

interface Strategy<T> {

    boolean isTarget(T t);

}
