package com.zhang.structural.proxy;

/**
 * Created by Zhang on 12/7/2016 10:33 PM.
 */
public class AtmMachine implements GetAtmData {

    AtmState hasCard;
    AtmState noCard;
    AtmState hasCorrectPin;
    AtmState atmOutOfMoney;

    AtmState atmState;
    int cashInMachine = 2000;
    boolean correctPinEntered = false;

    public AtmMachine() {
        hasCard = new HasCard(this);
        noCard = new NoCard(this);
        hasCorrectPin = new HasPin(this);
        atmOutOfMoney = new NoCash(this);

        atmState = noCard;

        if (cashInMachine == 0) {
            atmState = atmOutOfMoney;
        }
    }

    public void setCashInMachine(int cashInMachine) {
        this.cashInMachine = cashInMachine;
    }

    public AtmState getYesCardState() {
        return hasCard;
    }

    public AtmState getNoCardState() {
        return noCard;
    }

    public AtmState getHasPin() {
        return hasCorrectPin;
    }

    public AtmState getNoCashState() {
        return atmOutOfMoney;
    }

    public void insertCard() {
        atmState.insertCard();
    }

    public void ejectCard() {
        atmState.ejectCard();
    }

    public void requestCash(int cashToWithdraw) {
        atmState.requestCash(cashToWithdraw);
    }

    public void insertPin(int pinEntered) {
        atmState.insertPin(pinEntered);
    }

    @Override
    public AtmState getAtmState() {
        return atmState;
    }

    public void setAtmState(AtmState atmState) {
        this.atmState = atmState;
    }

    @Override
    public int getCashInMachine() {
        return cashInMachine;
    }
}
