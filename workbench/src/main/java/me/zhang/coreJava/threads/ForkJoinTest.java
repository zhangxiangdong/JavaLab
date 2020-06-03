package me.zhang.coreJava.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

/**
 * Created by zhangxiangdong on 2017/12/14.
 */
public class ForkJoinTest {

    public static void main(String[] args) {
        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) numbers[i] = Math.random();

        Counter counter = new Counter(numbers, 0, numbers.length, d -> d > 0.5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }

    static class Counter extends RecursiveTask<Integer> {

        public static final int THRESHOLD = 1000;
        private double[] values;
        private int from;
        private int to;
        private Predicate<Double> filter;

        public Counter(double[] values, int from, int to, Predicate<Double> filter) {
            this.values = values;
            this.from = from;
            this.to = to;
            this.filter = filter;
        }

        @Override
        protected Integer compute() {
            if (to - from < THRESHOLD) {
                int count = 0;
                for (int i = from; i < to; i++) {
                    if (filter.test(values[i])) count++;
                }
                return count;
            } else {
                int mid = (from + to) / 2;
                Counter first = new Counter(values, from, mid, filter);
                Counter second = new Counter(values, mid, to, filter);
                invokeAll(first, second);
                return first.join() + second.join();
            }
        }
    }

}
