package com.zhang.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Zhang on 11/26/2016 6:06 PM.
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        IvoryTower ivoryTower = IvoryTower.getInstance();
        LOGGER.info(ivoryTower.toString());

        EiffelTower eiffelTower = EiffelTower.getInstance();
        LOGGER.info(eiffelTower.toString());

        TokyoSkytree tokyoSkytree = TokyoSkytree.getInstance();
        LOGGER.info(tokyoSkytree.toString());

        AzadiTower azadiTower = AzadiTower.INSTANCE;
        LOGGER.info(azadiTower.toString());

        RomanTower romanTower = RomanTower.getInstance();
        LOGGER.info(romanTower.toString());
    }

}
