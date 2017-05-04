package me.zhang.dataStructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/5/4.
 */
public class DoublyLinkedListTest {

    @Test
    public void testDoublyLinkedListImplementation() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        Assert.assertEquals(0, linkedList.size());

        // Add.
        linkedList.addFirst(1);
        Assert.assertEquals(1, linkedList.size());
        Assert.assertEquals(1, linkedList.first().intValue());

        linkedList.addLast(2);
        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals(2, linkedList.last().intValue());

        // Remove.
        Assert.assertEquals(1, linkedList.removeFirst().intValue());
        Assert.assertEquals(1, linkedList.size());
        Assert.assertEquals(2, linkedList.first().intValue());
        Assert.assertEquals(2, linkedList.last().intValue());

        Assert.assertEquals(2, linkedList.removeLast().intValue());
        Assert.assertEquals(0, linkedList.size());
        Assert.assertEquals(null, linkedList.first());
        Assert.assertEquals(null, linkedList.last());
    }

}