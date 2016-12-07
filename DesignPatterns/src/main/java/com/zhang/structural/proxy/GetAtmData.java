package com.zhang.structural.proxy;

/**
 * Created by Zhang on 12/7/2016 10:30 PM.
 * <p>
 * This contain just those methods that you want the proxy to provide access to.
 */
public interface GetAtmData {

    public AtmState getAtmState();

    public int getCashInMachine();

}
