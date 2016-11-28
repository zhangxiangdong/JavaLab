package com.zhang.creational.singleton;

/**
 * Created by Zhang on 11/26/2016 9:13 PM.
 */
public class AzadiTowerTest extends SingletonTest<AzadiTower> {

    /**
     * Create a new singleton test instance using the given 'getInstance' method
     */
    public AzadiTowerTest() {
        super(() -> AzadiTower.INSTANCE);
    }
}