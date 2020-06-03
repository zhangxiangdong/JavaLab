package me.zhang.effective.item8;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

/**
 * Created by zhangxiangdong on 2017/12/22.
 */
public class PointTest {

    @Test
    public void testEquals() {
        ColorPoint redPoint = new ColorPoint(2, 2, Color.RED);
        Point diagonalPoint = new Point(2, 2);
        ColorPoint bluePoint = new ColorPoint(2, 2, Color.BLUE);

        Assert.assertFalse(redPoint.equals(diagonalPoint));
        Assert.assertFalse(redPoint.equals(bluePoint));
        Assert.assertTrue(diagonalPoint.equals(bluePoint.asPoint()));
    }

}