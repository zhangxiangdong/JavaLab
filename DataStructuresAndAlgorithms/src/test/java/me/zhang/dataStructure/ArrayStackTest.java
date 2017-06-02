package me.zhang.dataStructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhangxiangdong on 2017/6/2.
 */
public class ArrayStackTest {

    @Test(expected = IllegalStateException.class)
    public void testArrayStackMethods() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        arrayStack.push(0);
        assertEquals(0, arrayStack.top().intValue());
        assertEquals(1, arrayStack.size());
        assertFalse(arrayStack.isEmpty());

        assertEquals(0, arrayStack.pop().intValue());
        assertEquals(null, arrayStack.top());
        assertEquals(0, arrayStack.size());
        assertTrue(arrayStack.isEmpty());

        for (int i = 0; i < 1024; i++) {
            arrayStack.push(i);
        }
        arrayStack.push(1024);
    }

}