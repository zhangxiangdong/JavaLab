package com.zhang.builder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    @Test
    public void testBuildHero() throws Exception {
        final String heroName = "Sir Lancelot";

        final Hero hero = new Hero.Builder(Profession.MAGE, heroName)
                .withArmor(Armor.CHAIN_MAIL)
                .withHairColor(HairColor.BROWN)
                .withHairType(HairType.CURLY)
                .withWeapon(Weapon.AXE)
                .build();

        assertNotNull(hero);
        assertNotNull(hero.toString());

        assertEquals(Profession.MAGE, hero.getProfession());
        assertEquals(Armor.CHAIN_MAIL, hero.getArmor());
        assertEquals(HairColor.BROWN, hero.getHairColor());
        assertEquals(HairType.CURLY, hero.getHairType());
        assertEquals(Weapon.AXE, hero.getWeapon());
    }

}