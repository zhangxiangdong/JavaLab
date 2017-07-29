package me.zhang.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Zhang on 7/29/2017 3:54 PM.
 */
public class ReplacementTest {

    @Test(expected = NullPointerException.class)
    public void replaceBlankWithTwoPointers() throws Exception {
        String original = "We are happy.";
        String result = "We%20are%20happy.";

        assertEquals(result, original);

        original = " Wearehappy.";
        result = "%20Wearehappy.";
        assertEquals(result, original);

        original = "Wearehappy. ";
        result = "Wearehappy.%20";
        assertEquals(result, original);

        original = "We  are  happy.";
        result = "We%20%20are%20%20happy.";
        assertEquals(result, original);

        original = " Wearehappy. ";
        result = "%20Wearehappy.%20";
        assertEquals(result, original);

        original = "Wearehappy.";
        result = "Wearehappy.";
        assertEquals(result, original);

        original = "";
        result = "";
        assertEquals(result, original);

        original = " ";
        result = "%20";
        assertEquals(result, original);

        original = "   ";
        result = "%20%20%20";
        assertEquals(result, original);

        original = null;
        Replacement.replaceBlankWithTwoPointers(original);
    }

    private void assertEquals(String expected, String original) {
        String newString = Replacement.replaceBlankWithTwoPointers(original);
        Assert.assertEquals(expected, newString);
    }

}