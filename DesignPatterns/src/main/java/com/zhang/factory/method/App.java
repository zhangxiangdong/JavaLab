package com.zhang.factory.method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhangxiangdong on 2016/11/25.
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    private final Blacksmith blacksmith;

    public App(Blacksmith blacksmith) {
        this.blacksmith = blacksmith;
    }

    public static void main(String[] args) {
        App app = new App(new OrcBlacksmith());
        app.manufactureWeapons();

        app = new App(new ElfBlacksmith());
        app.manufactureWeapons();
    }

    private void manufactureWeapons() {
        Weapon weapon;
        weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
        LOGGER.info(weapon.toString());

        weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
        LOGGER.info(weapon.toString());
    }

}
