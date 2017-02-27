package me.zhang.tdd;

/**
 * Created by zhangxiangdong on 2017/2/27.
 */
public class Dollar {
    public int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }
}
