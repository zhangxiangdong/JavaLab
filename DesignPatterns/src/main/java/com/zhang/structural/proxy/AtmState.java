package com.zhang.structural.proxy;

/**
 * Created by Zhang on 12/7/2016 10:31 PM.
 */
public interface AtmState {

    void insertCard();

    void ejectCard();

    void insertPin(int pinEntered);

    void requestCash(int cashToWithdraw);

}
