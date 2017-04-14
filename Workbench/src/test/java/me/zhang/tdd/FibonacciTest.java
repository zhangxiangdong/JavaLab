package me.zhang.tdd;

import org.junit.Test;

import static me.zhang.tdd.Fibonacci.fib;
import static org.junit.Assert.assertEquals;

/**
 * Created by zhangxiangdong on 2017/4/14.
 */
public class FibonacciTest {

    @Test
    public void testFibMethod() {
        int cases[][] = {{0, 0}, {1, 1}, {2, 1}, {3, 2}};
        for (int[] aCase : cases) assertEquals(aCase[1], fib(aCase[0]));
    }

}
