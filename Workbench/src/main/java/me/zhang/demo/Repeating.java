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

}
