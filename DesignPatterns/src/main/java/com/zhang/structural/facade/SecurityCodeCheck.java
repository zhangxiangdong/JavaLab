package com.zhang.structural.facade;

/**
 * Created by Zhang on 12/6/2016 10:46 PM.
 */
public class SecurityCodeCheck {

    private int securityCode = 1234;

    public int getSecurityCode() {
        return securityCode;
    }

    public boolean isCodeCorrect(int secCodeToCheck) {
        return secCodeToCheck == getSecurityCode();
    }

}
