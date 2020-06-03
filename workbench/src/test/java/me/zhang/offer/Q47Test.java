package me.zhang.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/9/21.
 */
public class Q47Test {
    @Test
    public void add() throws Exception {
        int actual = Q47.add(2, 3);
        int expected = 5;
        Assert.assertEquals(expected, actual);

        actual = Q47.add(0, 0);
        expected = 0;
        Assert.assertEquals(expected, actual);

        actual = Q47.add(0, 4);
        expected = 4;
        Assert.assertEquals(expected, actual);

        actual = Q47.add(4, 0);
        expected = 4;
        Assert.assertEquals(expected, actual);

        actual = Q47.add(0, -3);
        expected = -3;
        Assert.assertEquals(expected, actual);

        actual = Q47.add(-3, 0);
        expected = -3;
        Assert.assertEquals(expected, actual);

        actual = Q47.add(-3, 2);
        expected = -1;
        Assert.assertEquals(expected, actual);

        actual = Q47.add(2, -3);
        expected = -1;
        Assert.assertEquals(expected, actual);
    }

}