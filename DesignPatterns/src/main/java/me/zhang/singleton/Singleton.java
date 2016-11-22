package me.zhang.singleton;

/**
 * Created by Zhang on 11/4/2015 9:09 下午.
 */
public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (uniqueInstance == null)
            uniqueInstance = new Singleton();
        return uniqueInstance;
    }

}
