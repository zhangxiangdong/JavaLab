package me.zhang.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/9/21.
 */
public class Q49Test {

    @Test
    public void atoi() throws Exception {
        long actual = Q49.atoi("123");
        long expected = 123;
        Assert.assertEquals(expected, actual);

        actual = Q49.atoi("+123");
        expected = 123;
        Assert.assertEquals(expected, actual);

        actual = Q49.atoi("0");
        expected = 0;
        Assert.assertEquals(expected, actual);

        actual = Q49.atoi("-123");
        expected = -123;
        Assert.assertEquals(expected, actual);

        try {
            Q49.atoi(null);
        } catch (NullPointerException e) {
            Assert.assertTrue(true);
        }
        try {
            Q49.atoi("");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
        try {
            Q49.atoi("1x3");
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(true);
        }
    }

}