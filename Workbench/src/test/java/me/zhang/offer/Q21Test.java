package me.zhang.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Zhang on 8/12/2017 9:41 AM.
 */
public class Q21Test {

    private Q21 q21 = new Q21();

    @Test
    public void min() throws Exception {
        q21.push(3);
        // container: 3 <-
        //       min: 3 <-
        Assert.assertEquals(3, q21.min());

        q21.push(4);
        // container: 3, 4 <-
        //       min: 3, 3 <-
        Assert.assertEquals(3, q21.min());

        q21.push(2);
        // container: 3, 4, 2 <-
        //       min: 3, 3, 2 <-
        Assert.assertEquals(2, q21.min());

        q21.push(1);
        // container: 3, 4, 2, 1 <-
        //       min: 3, 3, 2, 1 <-
        Assert.assertEquals(1, q21.min());

        q21.pop();
        // container: 3, 4, 2 <-
        //       min: 3, 3, 2 <-
        Assert.assertEquals(2, q21.min());

        q21.pop();
        // container: 3, 4 <-
        //       min: 3, 3 <-
        Assert.assertEquals(3, q21.min());

        q21.push(0);
        // container: 3, 4, 0 <-
        //       min: 3, 3, 0 <-
        Assert.assertEquals(0, q21.min());

    }

}