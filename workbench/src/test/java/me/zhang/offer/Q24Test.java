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
        Assert.assertTrue(q24.verifyPostorderSequenceOfBinarySearchTree(sequence));

        sequence = new int[]{7, 4, 6, 5};
        Assert.assertFalse(q24.verifyPostorderSequenceOfBinarySearchTree(sequence));
    }

    @Test
    public void verifyPreorderSequenceOfBinarySearchTree() throws Exception {
        int[] sequence = {5, 4, 2, 1, 3, 7, 6, 9, 8};
        Assert.assertTrue(q24.verifyPreorderSequenceOfBinarySearchTree(sequence));

        sequence = new int[]{7, 4, 6, 3};
        Assert.assertFalse(q24.verifyPreorderSequenceOfBinarySearchTree(sequence));
    }

}