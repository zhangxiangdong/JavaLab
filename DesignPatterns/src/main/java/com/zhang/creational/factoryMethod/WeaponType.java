package com.zhang.creational.factoryMethod;

/**
 * Created by zhangxiangdong on 2016/12/26.
 */
public enum WeaponType {

    SHORT_SWORD("short sword"), SPEAR("spear"), AXE("axe"), UNDEFINED("");

    String name;

    WeaponType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeaponType{" +
                "name='" + name + '\'' +
                '}';
    }
}
