package me.zhang.dataStructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/6/6.
 */
public class CircularlyLinkedQueueTest {

    @Test
    public void testCircularlyLinkedQueueOperations() {
        CircularlyLinkedQueue<Integer> queue = new CircularlyLinkedQueue<>();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);

        queue.rotate();
        Assert.assertEquals(1, queue.first().intValue());
        queue.rotate();
        Assert.assertEquals(2, queue.first().intValue());
    }

}