package com.zhang.structural.proxy;

/**
 * Created by Zhang on 12/7/2016 10:57 PM.
 */
public class AtmProxy implements GetAtmData {

    @Override
    public AtmState getAtmState() {
        GetAtmData atmMachine = new AtmMachine();
        return atmMachine.getAtmState();
    }

    @Override
    public int getCashInMachine() {
        GetAtmData atmMachine = new AtmMachine();
        return atmMachine.getCashInMachine();
    }
}
