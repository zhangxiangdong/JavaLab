package com.zhang.structural.proxy;

/**
 * Created by Zhang on 12/7/2016 11:00 PM.
 */
public class AtmMachineTest {

    public static void main(String[] args) {
        // The interface limits access to just the methods you want
        // made accessible

        GetAtmData atmProxy = new AtmProxy();

        System.out.println("\nCurrent ATM State " + atmProxy.getAtmState());

        System.out.println("\nCash in ATM Machine $" + atmProxy.getCashInMachine());

        // The user can't perform this action because AtmProxy doesn't
        // have access to that potentially harmful method
        // atmProxy.setCashInMachine(10000);
    }

}
