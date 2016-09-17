package me.zhang.singleton;

/**
 * Created by Zhang on 11/4/2015 9:09 下午.
 * <p>
 * Double Checked Locking
 */
public class DCLSingleton {

    /**
     * volatile 关键字确保，当uniqueInstance变量被初始化成实例时，多个线程正确地处理uniqueInstance变量
     */
    private static volatile DCLSingleton uniqueInstance;

    private DCLSingleton() {

    }

    public static DCLSingleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (DCLSingleton.class) {
                if (uniqueInstance == null)
                    uniqueInstance = new DCLSingleton();
            }
        }
        return uniqueInstance;
    }

}
