package me.zhang.coreJava;

/**
 * Created by Zhang on 10/2/2017 4:32 PM.
 */
public class CmdArgsTest {

    public static void main(String[] args) {
        if (args[0].equals("-h")) {
            System.out.print("Hello, ");
        } else if (args[0].equals("-g")) {
            System.out.print("Goodbye, ");
        }
        // print the other command-line arguments
        for (int i = 1; i < args.length; i++) {
            System.out.print(args[i]);
        }
        System.out.println("!");
    }

}
