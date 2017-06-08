package me.zhang.dataStructure;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by zhangxiangdong on 2017/6/8.
 */
public class DoublyLinkedDequeTest {

    @Test
    public void testDoublyLinkedDequeOperations() {
        Deque<Integer> deque = new DoublyLinkedDeque<>();
        deque.addFirst(0);
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
        assertEquals(0, deque.first().intValue());
        assertEquals(0, deque.last().intValue());

        deque.addLast(1);
        assertFalse(deque.isEmpty());
        assertEquals(2, deque.size());
        assertEquals(0, deque.first().intValue());
        assertEquals(1, deque.last().intValue());

        deque.removeFirst();
        assertFalse(deque.isEmpty());
        assertEquals(1, deque.size());
        assertEquals(1, deque.first().intValue());
        assertEquals(1, deque.last().intValue());

        deque.removeLast();
        Assert.assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
        assertEquals(null, deque.first());
        assertEquals(null, deque.last());
    }

}