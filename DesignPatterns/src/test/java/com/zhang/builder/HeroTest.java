package com.zhang.builder;

import org.junit.Test;

/**
 * Created by zhangxiangdong on 2016/11/23.
 */
public class HeroTest {

    /**
     * Test if we get the expected exception when trying to create a hero without a profession
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMissingProfession() throws Exception {
        new Hero.Builder(null, "Sir without a job");
    }

    /**
     * Test if we get the expected exception when trying to create a hero without a name
     */
    @Test(expected = IllegalArgumentException.class)
    public void testMissingName() throws Exception {
        new Hero.Builder(Profession.WARRIOR, null);
    }

}