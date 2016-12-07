package com.zhang.structural.proxy;

/**
 * Created by Zhang on 12/7/2016 10:35 PM.
 */
public class NoCard implements AtmState {

    AtmMachine atmMachine;

    public NoCard(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        
    }

    @Override
    public void ejectCard() {

    }

    @Override
    public void insertPin(int pinEntered) {

    }

    @Override
    public void requestCash(int cashToWithdraw) {

    }

    @Override
    public String toString() {
        return "No Card";
    }
}
