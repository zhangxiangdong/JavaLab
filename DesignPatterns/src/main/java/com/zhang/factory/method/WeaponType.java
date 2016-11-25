package com.zhang.factory.method;

/**
 * Created by zhangxiangdong on 2016/11/25.
 */
public enum WeaponType {

    SHORT_SWORD("short sword"), SPEAR("spear"), AXE("axe"), UNDEFINED("");

    private String title;

    WeaponType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}
