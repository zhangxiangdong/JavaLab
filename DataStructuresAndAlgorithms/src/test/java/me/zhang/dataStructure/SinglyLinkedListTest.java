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

    @Test
    public void testSinglyLinkedListEquivalence() {
        SinglyLinkedList<Integer> a = new SinglyLinkedList<>();
        a.addLast(1);
        a.addLast(2);
        a.addLast(3);

        SinglyLinkedList<Integer> b = new SinglyLinkedList<>();
        b.addLast(1);
        b.addLast(2);
        b.addLast(3);

        SinglyLinkedList<Integer> c = new SinglyLinkedList<>();
        c.addLast(1);
        c.addLast(2);

        SinglyLinkedList<Integer> d = null;

        SinglyLinkedList<Integer> e = new SinglyLinkedList<>();
        e.addLast(1);
        e.addLast(2);
        e.addLast(4);

        SinglyLinkedList<String> f = new SinglyLinkedList<>();

        Assert.assertTrue(a.equals(b));
        Assert.assertFalse(a.equals(c));
        Assert.assertFalse(a.equals(d));
        Assert.assertFalse(a.equals(e));
        Assert.assertFalse(a.equals(f));
    }

}