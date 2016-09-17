package me.zhang.basic.re;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zhang on 2016/4/18 上午 10:22 .
 */
public class ExcludeStringTestDrive {
    public static void main(String[] args) {
        /*
            programcreek matches
            programriver doesn't match
        */
        System.out.println("Positive Lookahead: ");
        look(".*program(?=creek).*");

        System.out.println("Negative Lookahead: ");
        look(".*program(?!creek).*");

        /*
            programcreek matches
            softwarecreek doesn't match
        */
        System.out.println("Positive Lookbehind: ");
        look(".*(?<=program)creek.*");

        System.out.println("Negative Lookbehind: ");
        look(".*(?<!program)creek.*");
    }

    private static void look(String pattern) {
        String s = "programcreek";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);

        if (m.matches()) {
            System.out.println("\tMatch");
        } else {
            System.out.println("\tNo");
        }
    }

}
