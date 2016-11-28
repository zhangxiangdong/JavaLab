package com.zhang.creational.singleton;

/**
 * Created by Zhang on 11/26/2016 9:15 PM.
 */
public class TokyoSkytreeTest extends com.zhang.creational.singleton.SingletonTest<TokyoSkytree> {

    /**
     * Create a new singleton test instance using the given 'getInstance' method
     */
    public TokyoSkytreeTest() {
        super(TokyoSkytree::getInstance);
    }
}