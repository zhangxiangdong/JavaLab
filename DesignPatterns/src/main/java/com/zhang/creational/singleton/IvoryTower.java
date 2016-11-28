package com.zhang.creational.singleton;

/**
 * Created by Zhang on 11/26/2016 6:04 PM.
 * <p>
 * Eagerly initialized static instance guarantees thread safety.
 */
public class IvoryTower {

    /**
     * Static to class INSTANCE of the class
     */
    private static final IvoryTower INSTANCE = new IvoryTower();

    public static IvoryTower getInstance() {
        return INSTANCE;
    }

    private IvoryTower() {
        if (INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        super.clone();
        throw new CloneNotSupportedException("Cannot clone INSTANCE of this class");
    }

}
