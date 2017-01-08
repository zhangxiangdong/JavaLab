package com.zhang.creational.factoryMethod;

/**
 * Created by zhangxiangdong on 2016/12/26.
 */
public class OrcWeapon implements Weapon {

    private WeaponType weaponType;

    public OrcWeapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public WeaponType getWeaponType() {
        return weaponType;
    }

    @Override
    public String toString() {
        return "OrcWeapon{" +
                "weaponType=" + weaponType +
                '}';
    }
}
