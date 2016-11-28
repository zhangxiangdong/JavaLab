package com.zhang.creational.singleton;

/**
 * Created by Zhang on 11/26/2016 9:05 PM.
 */
public class IvoryTowerTest extends SingletonTest<IvoryTower> {

    /**
     * Create a new singleton test instance using the given 'getInstance' method
     */
    public IvoryTowerTest() {
        super(IvoryTower::getInstance);
    }
}