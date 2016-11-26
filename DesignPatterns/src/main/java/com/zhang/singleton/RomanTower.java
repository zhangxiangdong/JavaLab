package com.zhang.singleton;

/**
 * Created by Zhang on 11/26/2016 8:27 PM.
 * <p>
 * Double check locking
 * <p/>
 * http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 * <p/>
 * Broken under Java 1.4.
 */
public class RomanTower {

    private static volatile RomanTower INSTANCE;

    public static RomanTower getInstance() {
        // local variable increases performance by 25 percent
        // Joshua Bloch "Effective Java, Second Edition", p. 283-284
        RomanTower result = INSTANCE;

        // Check if singleton INSTANCE is initialized. If it is initialized then we can return the INSTANCE.
        if (result == null) {
            // It is not initialized but we cannot be sure because some other thread might have initialized it
            // in the meanwhile. So to make sure we need to lock on an object to get mutual exclusion.
            synchronized (RomanTower.class) {
                // Again assign the INSTANCE to local variable to check if it was initialized by some other thread
                // while current thread was blocked to enter the locked zone. If it was initialized then we can
                // return the previously created INSTANCE just like the previous null check.
                result = INSTANCE;
                if (result == null) {
                    // The INSTANCE is still not initialized so we can safely (no other thread can enter this zone)
                    // create an INSTANCE and make it our singleton INSTANCE.
                    INSTANCE = result = new RomanTower();
                }
            }
        }
        return result;
    }

    private RomanTower() {
    }

}
