package me.zhang.recursion;

/**
 * Created by zhangxiangdong on 2017/5/15.
 * <p>
 * ***** / 1                 if n = 0
 * n! =
 * ***** \ n * (n - 1)       if n >= 1.
 */
public class FactorialFunction {

    public long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

}
