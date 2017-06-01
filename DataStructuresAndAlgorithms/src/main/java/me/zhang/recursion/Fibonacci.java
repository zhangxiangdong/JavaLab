package me.zhang.recursion;

/**
 * Created by zhangxiangdong on 2017/6/1.
 */
public class Fibonacci {

    public long bad(int n) {
        if (n <= 1) {
            return 1;
        }
        return bad(n - 2) + bad(n - 1);
    }

    public long[] good(int n) {
        if (n <= 1) {
            return new long[]{1, 0};
        }
        long[] result = good(n - 1);
        return new long[]{result[0] + result[1], result[0]};
    }

    public void loop(int n) {
        long a = 0;
        long b = 1;
        long c;
        System.out.println(a);
        System.out.println(b);
        for (int i = 2; i < n; i++) {
            c = b + a;
            a = b;
            b = c;
            System.out.println(c);
        }
    }

}
