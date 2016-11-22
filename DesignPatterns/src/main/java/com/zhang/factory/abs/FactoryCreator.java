package com.zhang.factory.abs;

/**
 * Created by zhangxiangdong on 2016/11/21.
 */
public class FactoryCreator {

    public static AbstractFactory<Bank> getBankFactory() {
        return new BankFactory();
    }

    public static AbstractFactory<Loan> getLoanFactory() {
        return new LoanFactory();
    }

}
