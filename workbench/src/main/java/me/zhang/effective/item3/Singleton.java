package me.zhang.effective.item3;

/**
 * Created by zhangxiangdong on 2017/12/19.
 */
public class Singleton {

    private static final Singleton INSTANCE = new Singleton();
    private static final ThreadLocal<Singleton> THREAD_LOCAL = ThreadLocal.withInitial(Singleton::new);

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public static Singleton getInstancePerThread() {
        return THREAD_LOCAL.get();
    }

    // preserve singleton property
    private Object readResolve() {
        return INSTANCE;
    }

}
