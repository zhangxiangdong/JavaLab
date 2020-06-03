package me.zhang.coreJava;

import java.io.Console;
import java.util.Scanner;

/**
 * Created by Zhang on 10/2/2017 9:37 AM.
 */
public class InputTest {

    public static void main(String[] args) {
        useScanner();
        useConsole();
    }

    private static void useConsole() {
        Console console = System.console();
        if (console == null) return;

        String userName = console.readLine("User name: ");
        char[] password = console.readPassword("Password: ");
        if ("Zhang".equals(userName) && "123".equals(new String(password))) {
            System.out.println("Login success");
        } else {
            System.out.println("Login failed");
        }
    }

    private static void useScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your name?");
        String yourName = scanner.nextLine();
        System.out.println("How old are you?");
        int yourAge = scanner.nextInt();
        System.out.println("Hi " + yourName + ". Next year your will be " + (yourAge + 1));
    }

}
