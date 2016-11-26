package com.zhang.singleton;

/**
 * Created by Zhang on 11/26/2016 6:29 PM.
 * <p>
 * Initializaing on demand holder idiom.
 */
public class EiffelTower {

    public static EiffelTower getInstance() {
        return TowerHolder.INSTANCE;
    }

    private static final class TowerHolder {
        private static final EiffelTower INSTANCE = new EiffelTower();
    }

    private EiffelTower() {
    }

}
