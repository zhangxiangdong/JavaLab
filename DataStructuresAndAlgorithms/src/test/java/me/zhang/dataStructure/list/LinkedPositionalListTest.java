package me.zhang.dataStructure.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/6/14.
 */
public class LinkedPositionalListTest {

    @Test//(expected = IllegalArgumentException.class)
    public void test() {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        list.addFirst(0);
        list.addLast(3);
        list.addAfter(list.first(), 1);
        list.addBefore(list.last(), 2);

        // 0, 1, 2, 3
        for (Integer i : list) {
            System.out.print(i + " ");
        }

        Assert.assertEquals(4, list.size());
        Assert.assertFalse(list.isEmpty());
        Assert.assertEquals(2, list.before(list.last()).getElement().intValue());
        Assert.assertEquals(1, list.after(list.first()).getElement().intValue());
        Assert.assertEquals(null, list.before(list.first()));
        Assert.assertEquals(null, list.after(list.last()));

//        list.addAfter(new Stub<>(), 4); // IllegalArgumentException
//        list.addBefore(new Node<>(null, -1, null), 5); // IllegalArgumentException

        list.set(list.first(), 100);

        // 100, 1, 2, 3
        System.out.println();
        Iterable<Position<Integer>> positions = list.positions();
        for (Position<Integer> p : positions) {
            System.out.print(p.getElement() + " ");
        }

        Assert.assertEquals(100, list.first().getElement().intValue());

        list.remove(list.last());

        // 100, 1, 2

        Assert.assertEquals(2, list.last().getElement().intValue());

        while (list.last() != null) {
            list.remove(list.last());
        }

        // empty

        Assert.assertEquals(0, list.size());
        Assert.assertTrue(list.isEmpty());
    }

    static class Stub<E> implements Position<E> {
        @Override
        public E getElement() throws IllegalStateException {
            return null;
        }
    }


}