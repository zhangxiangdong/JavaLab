package me.zhang.demo;

public class Repeating {

    int addFromOneToNRecursively(int n) {
        return n == 0 ? 0 : n + addFromOneToNRecursively(n - 1);
    }

    int addFromOneToNCyclically(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    int fibonacciRecursively(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciRecursively(n - 1) + fibonacciRecursively(n - 2);
        }
    }

    int fibonacciCyclically(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int r = 0, a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                r = a + b;
                a = b;
                b = r;
            }
            return r;
        }
    }

}
