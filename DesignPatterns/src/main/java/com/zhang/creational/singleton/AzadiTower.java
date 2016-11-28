package com.zhang.creational.singleton;

/**
 * Created by Zhang on 11/26/2016 7:03 PM.
 * <p>
 * Enum based singleton implementation. Effective Java 2nd Edition (Joshua Bloch) p. 18
 */
public enum AzadiTower {

    INSTANCE;

    @Override
    public String toString() {
        return getDeclaringClass().getCanonicalName() + "@" + hashCode();
    }
}
