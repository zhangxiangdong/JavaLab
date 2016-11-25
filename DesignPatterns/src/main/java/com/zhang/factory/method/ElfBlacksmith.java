package com.zhang.factory.method;

/**
 * Created by zhangxiangdong on 2016/11/25.
 */
public class ElfBlacksmith implements Blacksmith {

    @Override
    public Weapon manufactureWeapon(WeaponType weaponType) {
        return new ElfWeapon(weaponType);
    }

}
