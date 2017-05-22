package me.zhang.recursion;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/5/22.
 */
public class PowersTest {
    @Test
    public void power() throws Exception {
        Powers powers = new Powers();
        double result = powers.power(2, 3);
        Assert.assertEquals(8, result, 0);
    }

    @Test
    public void fasterPower() throws Exception {
        Powers powers = new Powers();
        double result = powers.fasterPower(2, 64);
        Assert.assertEquals(Math.pow(2, 64), result, 0);

        result = powers.fasterPower(2, 63);
        Assert.assertEquals(Math.pow(2, 63), result, 0);
    }

}