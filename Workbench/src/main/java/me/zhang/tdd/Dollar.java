package me.zhang.tdd;

/**
 * Created by zhangxiangdong on 2017/2/27.
 */
public class Dollar extends Money {

    public Dollar(int amount, String currency) {
        super(amount, currency);
    }

    @Override
    public Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }

}
