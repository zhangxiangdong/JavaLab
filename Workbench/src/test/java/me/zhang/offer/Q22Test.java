package me.zhang.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Zhang on 8/12/2017 10:47 AM.
 */
public class Q22Test {

    private Q22 q22 = new Q22();

    @Test
    public void isPopOrder() throws Exception {
        final int[] pushOrder = {1, 2, 3, 4, 5};
        int[] popOrder = {4, 5, 3, 2, 1};
        Assert.assertTrue(q22.isPopOrder(pushOrder, popOrder));

        popOrder = new int[]{4, 3, 5, 1, 2};
        Assert.assertFalse(q22.isPopOrder(pushOrder, popOrder));
    }

}