package me.zhang.tdd;

/**
 * Created by zhangxiangdong on 2017/2/27.
 */
public class Dollar extends Money {

    public Dollar(int amount) {
        super(amount);
    }

    @Override
    public Money times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

}
