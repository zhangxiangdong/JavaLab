package me.zhang.dataStructure.list;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/6/9.
 */
public class ArrayListTest {

    @Test(expected = IllegalStateException.class)
    public void add() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            list.add(i, i);
        }
        Assert.assertEquals(0, list.get(0).intValue());
        Assert.assertEquals(1, list.get(1).intValue());
        Assert.assertEquals(2, list.get(2).intValue());
        Assert.assertEquals(3, list.get(3).intValue());
        Assert.assertEquals(4, list.get(4).intValue());

        list.add(16, 1024);
    }

    @Test
    public void remove() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i, i);
        }
        Assert.assertEquals(4, list.remove(4).intValue());
        Assert.assertEquals(3, list.remove(3).intValue());
        Assert.assertEquals(2, list.remove(2).intValue());
        Assert.assertEquals(1, list.remove(1).intValue());
        Assert.assertEquals(0, list.remove(0).intValue());
    }

    @Test
    public void set() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i, i);
        }
        Assert.assertEquals(3, list.get(3).intValue());
        list.set(3, -1);
        Assert.assertEquals(-1, list.get(3).intValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i, i);
        }
        Assert.assertEquals(0, list.get(0).intValue());
        Assert.assertEquals(1, list.get(1).intValue());
        Assert.assertEquals(2, list.get(2).intValue());
        Assert.assertEquals(3, list.get(3).intValue());
        Assert.assertEquals(4, list.get(4).intValue());

        list.get(5);
    }

    @Test
    public void size() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        Assert.assertEquals(0, list.size());

        list.add(0, 0);
        Assert.assertEquals(1, list.size());

        list.add(1, 1);
        Assert.assertEquals(2, list.size());

        list.remove(1);
        Assert.assertEquals(1, list.size());

        list.remove(0);
        Assert.assertEquals(0, list.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void isEmpty() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        Assert.assertTrue(list.isEmpty());

        list.add(0, 0);
        Assert.assertFalse(list.isEmpty());

        list.add(1, 1);
        Assert.assertFalse(list.isEmpty());

        list.remove(1);
        Assert.assertFalse(list.isEmpty());

        list.set(0, -1);
        Assert.assertFalse(list.isEmpty());

        list.get(0);
        Assert.assertFalse(list.isEmpty());

        list.remove(0);
        Assert.assertTrue(list.isEmpty());

        list.get(-1);
        list.get(3);
        list.get(0);
    }

}