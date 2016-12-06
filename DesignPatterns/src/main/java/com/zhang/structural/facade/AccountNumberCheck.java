package com.zhang.structural.facade;

/**
 * Created by Zhang on 12/6/2016 10:45 PM.
 */
public class AccountNumberCheck {

    private int accountNumber = 12345678;

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean accountActive(int acctNumToCheck) {
        return acctNumToCheck == getAccountNumber();
    }

}
