package me.zhang.coreJava.io;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangxiangdong on 2017/12/22.
 */
public class RETest {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Choose func");
            System.out.println("\t 0: matches 1: find");
            String choose = in.nextLine();
            try {
                int fun = Integer.parseInt(choose);
                if (fun == 0) {
                    matches(in);
                } else if (fun == 1) {
                    find(in);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    private static void matches(Scanner in) {
        System.out.println("matches(): ");
        // Time format, e.g. 7:30AM
        final String patternString = "^((1?[0-9]):([0-5][0-9]))[aApP][mM]$";
        Pattern pattern = Pattern.compile(patternString);
        while (true) {
            String line = in.nextLine();
            if (shouldBreak(line)) break;
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                System.out.println("Valid time format.");
            } else {
                System.out.println("Invalid time format.");
            }
        }
    }

    private static void find(Scanner in) {
        System.out.println("find(): ");
        // search for all occurrences of pattern
        final String patternString = "((1?[0-9]):([0-5][0-9]))[aApP][mM]";
        Pattern pattern = Pattern.compile(patternString);
        while (true) {
            String line = in.nextLine();
            if (shouldBreak(line)) break;
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                // int start = matcher.start();
                // int end = matcher.end();
                // String match = line.substring(start, end);
                String match = matcher.group();
                System.out.println(match);
            }
            // Splits the given input
            System.out.println(Arrays.toString(pattern.split(line)));
        }
    }

    private static boolean shouldBreak(String line) {
        if ("EXIT".equalsIgnoreCase(line)) {
            System.out.println("Exit!");
            return true;
        }
        return false;
    }

}
