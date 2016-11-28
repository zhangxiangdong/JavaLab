package com.zhang.creational.factory.method;

/**
 * Created by zhangxiangdong on 2016/11/25.
 */
public class OrcBlacksmith implements Blacksmith {

    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return new OrcWeapon(weaponType);
    }

}
