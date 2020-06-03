package me.zhang.dsa;

import org.junit.Assert;
import org.junit.Test;

public class QueueWithTwoStacksTest {

    private QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();

    @Test(expected = IllegalStateException.class)
    public void testQueueOprations() throws Exception {

        for (int i = 0; i < 10; i++) {
            queue.appendTail(i);
        }

        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, queue.deleteHead().intValue());
        }

        queue.appendTail(1);
        queue.appendTail(10);
        queue.appendTail(100);
        Assert.assertEquals(1, queue.deleteHead().intValue());

        queue.appendTail(1000);
        Assert.assertEquals(10, queue.deleteHead().intValue());
        Assert.assertEquals(100, queue.deleteHead().intValue());

        queue.appendTail(10000);
        Assert.assertEquals(1000, queue.deleteHead().intValue());
        Assert.assertEquals(10000, queue.deleteHead().intValue());

        queue.deleteHead();
    }

}