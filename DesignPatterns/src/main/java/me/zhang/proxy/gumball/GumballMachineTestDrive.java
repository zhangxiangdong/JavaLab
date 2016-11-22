package me.zhang.proxy.gumball;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

/**
 * Created by Zhang on 12/6/2015 4:37 下午.
 */
public class GumballMachineTestDrive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Location: ");
        String location = scanner.nextLine();
        System.out.print("Count: ");
        int count = scanner.nextInt();

        try {
            GumballMachineRemote gumballMachine = new GumballMachine(location, count);
            LocateRegistry.createRegistry(80).rebind(location + "/gumballmachine", gumballMachine);
//            Naming.rebind(location + "/gumballmachine", gumballMachine);
//            LocateRegistry.getRegistry().rebind(location + "/gumballmachine", gumballMachine);
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
//        System.out.println(gumballMachine);
//
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//        System.out.println(gumballMachine);
//
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//        gumballMachine.insertQuarter();
//        gumballMachine.turnCrank();
//        System.out.println(gumballMachine);
//
//        gumballMachine.turnCrank();
//        System.out.println(gumballMachine);
//
//        GumballMonitor monitor = new GumballMonitor(gumballMachine);
//        monitor.report();

            scanner.close();
        }
    }
}
