package me.zhang.recursion;

/**
 * Created by zhangxiangdong on 2017/5/15.
 * <p>
 * ***** / 1                 if n = 0
 * n! =
 * ***** \ n * (n - 1)       if n >= 1.
 */
public class FactorialFunction {

    public long recursion(int n) {
        if (n == 0) {
            return 1;
        }
        return n * recursion(n - 1);
    }

    public long loop(int n) {
        long s = 1;
        for (int i = 0; i < n; i++) {
            s += s * i;
        }
        return s;
    }

}
