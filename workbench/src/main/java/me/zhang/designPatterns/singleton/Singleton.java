package me.zhang.designPatterns.singleton;

/**
 * Created by Zhang on 7/29/2017 10:10 AM.
 */
public abstract class Singleton<T> {

    private T instance;

    public final T get() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = create();
                }
            }
        }
        return instance;
    }

    protected abstract T create();

}
