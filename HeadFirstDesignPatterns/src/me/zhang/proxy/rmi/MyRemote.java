package me.zhang.proxy.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Zhang on 1/2/2016 1:03 下午.
 */
public interface MyRemote extends Remote {

    String sayHello() throws RemoteException;

}
