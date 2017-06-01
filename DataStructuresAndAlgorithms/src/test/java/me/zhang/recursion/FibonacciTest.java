package me.zhang.recursion;

import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/6/1.
 */
public class FibonacciTest {
    @Test
    public void bad() throws Exception {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 10; i++) {
            System.out.println(fibonacci.bad(i));
        }
        System.out.println("*****************");
        for (int i = 1; i < 11; i++) {
            System.out.println(fibonacci.good(i)[0]);
        }
        System.out.println("*****************");
        fibonacci.loop(10);
    }

}