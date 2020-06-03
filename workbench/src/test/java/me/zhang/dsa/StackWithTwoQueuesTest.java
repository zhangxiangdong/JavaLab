package me.zhang.dsa;

import org.junit.Assert;
import org.junit.Test;

public class StackWithTwoQueuesTest {

    @Test(expected = IllegalStateException.class)
    public void testStackOprations() {
        StackWithTwoQueues<Integer> stack = new StackWithTwoQueues<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 9; i >= 0; i--) {
            Assert.assertEquals(i, stack.pop().intValue());
        }

        stack.push(1);
        stack.push(10);
        stack.push(100);
        Assert.assertEquals(100, stack.pop().intValue());
        Assert.assertEquals(10, stack.pop().intValue());

        stack.push(1000);
        stack.push(10000);
        Assert.assertEquals(10000, stack.pop().intValue());
        Assert.assertEquals(1000, stack.pop().intValue());
        Assert.assertEquals(1, stack.pop().intValue());

        stack.pop();
    }

}