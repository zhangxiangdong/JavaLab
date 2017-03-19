package me.zhang.fundamentalDataTypes;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Zhang on 3/19/2017 12:18 PM.
 */
public class CheckerboardTest {

    @Test
    public void returnBlueIfColAndRowAreBothEvenOrOdd_elseReturnRedColor() {
        Checkerboard checkerboard = new Checkerboard();
        int color00 = checkerboard.getColor(0, 0);
        Assert.assertEquals(0, color00);

        int color11 = checkerboard.getColor(1, 1);
        Assert.assertEquals(0, color11);

        int color21 = checkerboard.getColor(2, 1);
        Assert.assertEquals(1, color21);

        int color12 = checkerboard.getColor(1, 2);
        Assert.assertEquals(1, color12);
    }

}