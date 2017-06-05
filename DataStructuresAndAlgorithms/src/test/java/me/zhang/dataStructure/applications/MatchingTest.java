package me.zhang.dataStructure.applications;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/6/5.
 */
public class MatchingTest {

    @Test
    public void matchParenthesis() {
        Matching matching = new Matching();

        final String expression0 = "{a + b * (c + d) - a / [b + c]}";
        Assert.assertTrue(matching.isMatch(expression0));

        final String expression1 = "{a + b * [c + d) - a / (b + c]}";
        Assert.assertFalse(matching.isMatch(expression1));

        final String expression2 = "{a + b * (c + d) - a / [b + c]";
        Assert.assertFalse(matching.isMatch(expression2));

        final String expression3 = "{a + [b * (c + d) - a / [b + c]}";
        Assert.assertFalse(matching.isMatch(expression3));
    }

}