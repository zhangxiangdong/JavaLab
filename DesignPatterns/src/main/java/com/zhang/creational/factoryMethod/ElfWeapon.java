package com.zhang.creational.factoryMethod;

/**
 * Created by zhangxiangdong on 2016/12/26.
 */
public class ElfWeapon implements Weapon {

    private WeaponType weaponType;

    public ElfWeapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }

    @Override
    public String toString() {
        return "ElfWeapon{" +
                "weaponType=" + weaponType +
                '}';
    }
}
