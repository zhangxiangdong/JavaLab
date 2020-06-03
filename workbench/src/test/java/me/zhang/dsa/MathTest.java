package me.zhang.dsa;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Zhang on 8/5/2017 9:24 AM.
 */
public class MathTest {

    private Math math = new Math();

    @Test(expected = IllegalArgumentException.class)
    public void power() throws Exception {
        double expected = java.lang.Math.pow(2, 2);
        Assert.assertEquals(expected, math.power(2, 2), Math.THRESHOLD);

        expected = java.lang.Math.pow(2, -4);
        Assert.assertEquals(expected, math.power(2, -4), Math.THRESHOLD);

        expected = java.lang.Math.pow(0, 3);
        Assert.assertEquals(expected, math.power(0, 3), Math.THRESHOLD);

        expected = java.lang.Math.pow(0.00000001, 3);
        Assert.assertEquals(expected, math.power(0, 3), Math.THRESHOLD);

        math.power(0, -1);
    }

}