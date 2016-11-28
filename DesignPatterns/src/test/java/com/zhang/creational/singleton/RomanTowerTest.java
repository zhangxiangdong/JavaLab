package com.zhang.creational.singleton;

/**
 * Created by Zhang on 11/26/2016 9:16 PM.
 */
public class RomanTowerTest extends com.zhang.creational.singleton.SingletonTest<RomanTower> {

    /**
     * Create a new singleton test instance using the given 'getInstance' method
     */
    public RomanTowerTest() {
        super(RomanTower::getInstance);
    }
}