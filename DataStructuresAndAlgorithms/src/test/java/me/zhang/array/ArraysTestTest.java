package me.zhang.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by zhangxiangdong on 2017/5/5.
 */
public class ArraysTestTest {

    @Test
    public void testArrayClone() {
        int[] a = {0, 1, 2, 3, 4, 5};
        int[] b = a;
        int[] c = a.clone();

        Assert.assertTrue(b == a);
        Assert.assertFalse(c == a);
        Assert.assertTrue(Arrays.equals(c, a));

        a[0] = -1; // a[0] == -1 while c[0] == 0
        Assert.assertFalse(a[0] == c[0]);
        Assert.assertTrue(0 == c[0]);
    }

}