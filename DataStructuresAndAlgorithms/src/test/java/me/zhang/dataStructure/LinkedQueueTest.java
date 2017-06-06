package me.zhang.dataStructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/6/6.
 */
public class LinkedQueueTest {

    @Test
    public void testQueueOperations() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        Assert.assertTrue(queue.isEmpty());
        Assert.assertEquals(0, queue.size());

        queue.enqueue(0);
        Assert.assertFalse(queue.isEmpty());
        Assert.assertEquals(1, queue.size());

        Integer first = queue.first();
        Assert.assertEquals(0, first.intValue());
        Assert.assertEquals(0, queue.dequeue().intValue());
        Assert.assertTrue(queue.isEmpty());
        Assert.assertEquals(0, queue.size());
    }

}