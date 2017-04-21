package me.zhang.numeric;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zhangxiangdong on 2017/4/21.
 */
public class ProgressionTest {

    public static final String EXPECTED_DEFAULT_PROGRESSION_2 = "0, 1, 2";
    public static final String EXPECTED_SF7_DEFAULT_PROGRESSION_3 = "7, 8, 9, 10";

    @Test
    public void returnNextValue() {
        // Default constructor, progression starting from zero.
        Progression progression = new Progression();
        Assert.assertEquals(1, progression.nextValue());
        Assert.assertEquals(2, progression.nextValue());
    }

    @Test
    public void constructWithStartingNumber() {
        final long start = 7;
        Progression progression = new Progression(start);
        Assert.assertEquals(start + 1, progression.nextValue());
        Assert.assertEquals(start + 2, progression.nextValue());
    }

    @Test
    public void printThemOut() {
        Progression defaultProgression = new Progression();
        Assert.assertEquals(EXPECTED_DEFAULT_PROGRESSION_2, defaultProgression.printProgression(2));

        Progression sf7Progression = new Progression(7);
        Assert.assertEquals(EXPECTED_SF7_DEFAULT_PROGRESSION_3, sf7Progression.printProgression(3));
    }

}