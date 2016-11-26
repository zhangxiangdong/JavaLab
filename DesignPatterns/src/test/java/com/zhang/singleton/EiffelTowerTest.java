package com.zhang.singleton;

/**
 * Created by Zhang on 11/26/2016 9:02 PM.
 */
public class EiffelTowerTest extends SingletonTest<EiffelTower> {

    /**
     * Create a new singleton test instance using the given 'getInstance' method
     */
    public EiffelTowerTest() {
        super(EiffelTower::getInstance);
    }
}