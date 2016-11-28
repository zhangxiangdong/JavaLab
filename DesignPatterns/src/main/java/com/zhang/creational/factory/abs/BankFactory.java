package com.zhang.creational.factory.abs;

/**
 * Created by zhangxiangdong on 2016/11/21.
 */
public class BankFactory extends AbstractFactory<Bank> {

    @Override
    public Bank get(String bank) {
        if (bank == null) {
            return null;
        }
        if (bank.equalsIgnoreCase("HDFC")) {
            return new HDFC();
        } else if (bank.equalsIgnoreCase("ICICI")) {
            return new ICICI();
        } else if (bank.equalsIgnoreCase("SBI")) {
            return new SBI();
        }
        return null;
    }

}
