package me.zhang.tdd;

/**
 * Created by zhangxiangdong on 2017/2/28.
 */
public class Money {

    protected int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount && getClass().equals(money.getClass());
    }

}
