package com.zhang.structural.facade;

import org.junit.Test;

/**
 * Created by Zhang on 12/6/2016 10:50 PM.
 */
public class BankAccountTest {

    @Test
    public void test() {
        BankAccountFacade accessingBank = new BankAccountFacade(12345678, 1234);
        accessingBank.withdrawCash(50.00);
        accessingBank.withdrawCash(990.00);
    }

}
