package me.zhang.demo;

import org.junit.Assert;
import org.junit.Test;

public class RepeatingTest {

    private Repeating repeating = new Repeating();

    @Test
    public void addFromOneToN() throws Exception {
        int expected = (1 + 100) * 100 >>> 1;
        Assert.assertEquals(5050, expected);

        int actual = repeating.addFromOneToNRecursively(100);
        Assert.assertEquals(expected, actual);

        actual = repeating.addFromOneToNCyclically(100);
        Assert.assertEquals(expected, actual);
    }

}