package me.zhang.dataStructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/5/3.
 */
public class CircularlyLinkedListTest {

    @Test
    public void testCirclarlyLinkedListImplementation() {
        CircularlyLinkedList<Integer> linkedList = new CircularlyLinkedList<>();
        Assert.assertEquals(0, linkedList.size());

        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        Assert.assertEquals(3, linkedList.size());
        Assert.assertEquals(1, linkedList.first().intValue());
        Assert.assertEquals(3, linkedList.last().intValue());

        Assert.assertEquals(1, linkedList.removeFirst().intValue());
        Assert.assertEquals(2, linkedList.size());

        Assert.assertEquals(2, linkedList.removeFirst().intValue());
        Assert.assertEquals(1, linkedList.size());

        Assert.assertEquals(3, linkedList.removeFirst().intValue());
        Assert.assertEquals(0, linkedList.size());

        // ************************** Reload

        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.addLast(3);

        linkedList.rotate();
        Assert.assertEquals(2, linkedList.first().intValue());

        linkedList.rotate();
        Assert.assertEquals(3, linkedList.first().intValue());
    }

}