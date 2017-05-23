package me.zhang.recursion;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/5/23.
 */
public class BinarySumTest {
    @Test
    public void sumUp() throws Exception {
        final int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySum sum = new BinarySum();
        Assert.assertEquals((a[0] + a[a.length - 1]) * (a.length) / 2, sum.sumUp(a, 0, a.length - 1));
    }

}