package me.zhang.tdd;

/**
 * Created by zhangxiangdong on 2017/3/1.
 */
public class Sum implements Expression {

    public Money augend;
    public Money addend;

    public Sum(Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(String to) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, to);
    }

}
