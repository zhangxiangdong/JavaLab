package com.zhang.creational.factoryMethod;

/**
 * Created by zhangxiangdong on 2016/12/26.
 */
public class App {

    public static void main(String[] args) {
        Blacksmith elfBlacksmith = new ElfBlacksmith();
        Weapon elfAxe = elfBlacksmith.manufactureWeapon(WeaponType.AXE);
        System.out.println(elfAxe);

        Blacksmith orcBlacksmith = new OrcBlacksmith();
        Weapon orcSpear = orcBlacksmith.manufactureWeapon(WeaponType.SPEAR);
        System.out.println(orcSpear);
    }

}
