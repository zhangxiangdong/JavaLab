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
        assertEquals(1, function.recursion(0));
        assertEquals(1, function.recursion(1));
        assertEquals(120, function.recursion(5));
        assertEquals(function.recursion(8) * 9, function.recursion(9));

        assertEquals(1, function.loop(0));
        assertEquals(1, function.loop(1));
        assertEquals(120, function.loop(5));
        assertEquals(function.loop(8) * 9, function.loop(9));
    }

}