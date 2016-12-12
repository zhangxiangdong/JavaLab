package com.zhang.structural.proxy;

/**
 * Created by Zhang on 12/7/2016 10:57 PM.
 */
public class AtmProxy implements GetAtmData {

    AtmMachine atmMachine;

    public AtmProxy(AtmMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public AtmState getAtmState() {
        return atmMachine.getAtmState();
    }

    @Override
    public int getCashInMachine() {
        return atmMachine.getCashInMachine();
    }
}
