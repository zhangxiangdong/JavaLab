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
        hasCorrectPin = new HasCorrectPin(this);
        atmOutOfMoney = new AtmOutOfMoney(this);

        atmState = noCard;
    }

    public void setCashInMachine(int cashInMachine) {
        this.cashInMachine = cashInMachine;
    }

    @Override
    public AtmState getAtmState() {
        return atmState;
    }

    @Override
    public int getCashInMachine() {
        return cashInMachine;
    }
}
