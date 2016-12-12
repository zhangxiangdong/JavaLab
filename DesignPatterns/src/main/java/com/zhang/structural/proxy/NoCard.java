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
        System.out.println("Please enter your pin");
        atmMachine.setAtmState(atmMachine.getYesCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("You didn't enter a card");
    }

    @Override
    public void insertPin(int pinEntered) {
        System.out.println("You have not insert your card");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("You have not insert your card");
    }

    @Override
    public String toString() {
        return "No Card";
    }
}
