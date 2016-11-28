package com.zhang.creational.singleton;

/**
 * Created by Zhang on 11/26/2016 6:59 PM.
 * <p>
 * Thread safe lazy loaded Tokyo Skytree.
 */
public class TokyoSkytree {

    private static TokyoSkytree INSTANCE;

    public static synchronized TokyoSkytree getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TokyoSkytree();
        }
        return INSTANCE;
    }

    private TokyoSkytree() {
    }

}
