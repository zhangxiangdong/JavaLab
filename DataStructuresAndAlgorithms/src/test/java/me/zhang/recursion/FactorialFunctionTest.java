package me.zhang.recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhangxiangdong on 2017/5/15.
 */
public class FactorialFunctionTest {

    @Test
    public void testFactorialFunctionCorrectness() {
        FactorialFunction function = new FactorialFunction();
        assertEquals(1, function.factorial(0));
        assertEquals(1, function.factorial(1));
        assertEquals(120, function.factorial(5));
        assertEquals(function.factorial(8) * 9, function.factorial(9));
    }

}