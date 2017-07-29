package me.zhang.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Zhang on 7/29/2017 12:19 PM.
 */
public class AppTest {

    private int[][] a = {
            {1, 2, 8, 9},
            {2, 4, 9, 12},
            {4, 7, 10, 13},
            {6, 8, 11, 15}
    };

    @Test(expected = IllegalArgumentException.class)
    public void searchFromTopRight() throws Exception {
        int target = 1;
        boolean result = App.searchFromTopRight(a, target);
        Assert.assertTrue(result);

        target = 7;
        result = App.searchFromTopRight(a, target);
        Assert.assertTrue(result);

        target = 15;
        result = App.searchFromTopRight(a, target);
        Assert.assertTrue(result);

        target = 17;
        result = App.searchFromTopRight(a, target);
        Assert.assertFalse(result);

        target = -2;
        result = App.searchFromTopRight(a, target);
        Assert.assertFalse(result);

        target = 18;
        result = App.searchFromTopRight(a, target);
        Assert.assertFalse(result);

        target = 7;
        App.searchFromTopRight(null, target);
        App.searchFromTopRight(new int[][]{}, target);
        App.searchFromTopRight(new int[][]{{}}, target);
    }

}