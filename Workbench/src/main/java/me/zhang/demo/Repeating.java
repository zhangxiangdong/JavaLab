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

    /**
     * 一个台阶总共有n级，如果一次可以跳1级，也可以跳2级...它也可以跳上n级。此时该青蛙跳上一个n级的台阶总共有多少种跳法？
     *
     * @param n 台阶数
     * @return 跳法
     */
    int frogJump(int n) {
        /*           1               n = 0
         *         /
         * f(n) =    1               n = 1
         *         \
         *           2 * f(n - 1)    n >= 2
         */
        // 根据等比数列规律，得出：
        // f(n) =    2^(n - 1)       n >= 1
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return 2 * frogJump(n - 1);
        }
    }

}
