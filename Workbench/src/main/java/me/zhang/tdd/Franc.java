package me.zhang.tdd;

/**
 * Created by zhangxiangdong on 2017/2/27.
 */
public class Franc extends Money {

    public Franc(int amount) {
        super(amount);
    }

    @Override
    public Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }

}
