package me.zhang.singleton;

/**
 * Created by Zhang on 11/4/2015 9:09 下午.
 */
public class EagerSingleton {

    private static EagerSingleton uniqueInstance = new EagerSingleton();

    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return uniqueInstance;
    }

}
