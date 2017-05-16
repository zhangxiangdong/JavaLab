package me.zhang.recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhangxiangdong on 2017/5/16.
 */
public class BinarySearchTest {

    @Test
    public void testBinarySearchCorrectness() {
        BinarySearch search = new BinarySearch();
        final int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        final int targetExist = 5;

        int index = search.recursion(a, targetExist, 0, a.length - 1);
        assertEquals(5, index);

        final int targetNotExist = 12;
        index = search.recursion(a, targetNotExist, 0, a.length - 1);
        assertEquals(-1, index);

        index = search.loop(a, targetExist, 0, a.length - 1);
        assertEquals(5, index);

        index = search.loop(a, targetNotExist, 0, a.length - 1);
        assertEquals(-1, index);
    }

}