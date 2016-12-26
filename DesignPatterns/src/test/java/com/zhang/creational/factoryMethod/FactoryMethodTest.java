package com.zhang.creational.factoryMethod;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zhangxiangdong on 2016/12/26.
 */
public class FactoryMethodTest {

    private Blacksmith orcBlacksmith;
    private Blacksmith elfBlacksmith;

    @Before
    public void setUp() {
        orcBlacksmith = new OrcBlacksmith();
        elfBlacksmith = new ElfBlacksmith();
    }

    @Test
    public void testOrcBlacksmith() {
        Weapon orcAxe = orcBlacksmith.manufactureWeapon(WeaponType.AXE);
        verifyWeapon(orcAxe, WeaponType.AXE, Weapon.class);
    }

    @Test
    public void testElfBlacksmith() {
        Weapon elfSpear = elfBlacksmith.manufactureWeapon(WeaponType.SPEAR);
        verifyWeapon(elfSpear, WeaponType.SPEAR, Weapon.class);
    }

    /**
     * This method asserts that the weapon object that is passed is an instance of the clazz and the
     * weapon is of type expectedWeaponType.
     *
     * @param weapon             weapon object which is to be verified
     * @param expectedWeaponType expected WeaponType of the weapon
     * @param clazz              expected class of the weapon
     */
    private void verifyWeapon(Weapon weapon, WeaponType expectedWeaponType, Class<?> clazz) {
        assertTrue("Weapon must be an object of: " + clazz.getName(), clazz.isInstance(weapon));
        assertEquals("Weapon must be of weaponType: " + clazz.getName(), expectedWeaponType,
                weapon.getWeaponType());
    }

}
