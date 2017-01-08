package com.zhang.creational.factoryMethod;

/**
 * Created by zhangxiangdong on 2016/12/26.
 */
public class ElfBlacksmith implements Blacksmith {
    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return new ElfWeapon(weaponType);
    }
}
