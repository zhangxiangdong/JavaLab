package me.zhang.dataStructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/5/3.
 */
public class SinglyLinkedListTest {

    @Test
    public void testSinglyLinkedListImplementation() {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        Assert.assertEquals(0, linkedList.size());

        linkedList.addFirst(10);
        Assert.assertEquals(1, linkedList.size());
        Assert.assertEquals(10, linkedList.first().intValue());

        linkedList.addLast(1);
        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals(1, linkedList.last().intValue());

        Assert.assertEquals(10, linkedList.removeFirst().intValue());
        Assert.assertEquals(1, linkedList.size());

    }

}