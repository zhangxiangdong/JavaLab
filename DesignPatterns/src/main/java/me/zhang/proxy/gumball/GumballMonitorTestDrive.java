package me.zhang.proxy.gumball;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 * Created by Zhang on 1/6/2016 10:06 下午.
 */
public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Location: ");
        String location = scanner.nextLine();
        try {
            GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup("rmi://192.168.1.101:80/" + location + "/gumballmachine");
//            GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup("rmi://127.0.0.1/" + location + "/gumballmachine");
            System.out.println(machine);
            GumballMonitor monitor = new GumballMonitor(machine);
            monitor.report();
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
