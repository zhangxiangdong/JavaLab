package me.zhang.offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Zhang on 8/13/2017 11:17 AM.
 */
public class Q24Test {

    private Q24 q24 = new Q24();

    @Test
    public void verifySequenceOfBinarySearchTree() throws Exception {
        int[] sequence = {5, 7, 6, 9, 11, 10, 8};
        Assert.assertTrue(q24.verifySequenceOfBinarySearchTree(sequence));

        sequence = new int[]{7, 4, 6, 5};
        Assert.assertFalse(q24.verifySequenceOfBinarySearchTree(sequence));
    }

}