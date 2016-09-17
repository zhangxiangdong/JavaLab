package me.zhang.proxy.gumball;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Zhang on 1/5/2016 9:29 下午.
 */
public interface GumballMachineRemote extends Remote {
    int getCount() throws RemoteException;

    String getLocation() throws RemoteException;

    State getState() throws RemoteException;
}
