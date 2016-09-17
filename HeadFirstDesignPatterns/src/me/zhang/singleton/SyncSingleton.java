package me.zhang.singleton;

/**
 * Created by Zhang on 11/4/2015 9:09 下午.
 */
public class SyncSingleton {

    private static SyncSingleton uniqueInstance;

    private SyncSingleton() {

    }

    public static synchronized SyncSingleton getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new SyncSingleton();
        return uniqueInstance;
    }

}
