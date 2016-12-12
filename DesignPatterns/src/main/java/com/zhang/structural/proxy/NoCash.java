package com.zhang.structural.proxy;

/**
 * Created by Zhang on 12/7/2016 10:35 PM.
 */
public class NoCash implements AtmState {

    AtmMachine atmMachine;

    public NoCash(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("We don't have any money");
        System.out.println("You can only insert one card at a time");
    }

    @Override
    public void ejectCard() {
        System.out.println("We don't have any money");
        atmMachine.setAtmState(atmMachine.getNoCardState());
        System.out.println("Your card is ejected");
    }

    @Override
    public void insertPin(int pinEntered) {
        System.out.println("We don't have any money");
        System.out.println("You already entered a PIN");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("We don't have any money");
    }

    @Override
    public String toString() {
        return "ATM Out Of Money!";
    }
}
