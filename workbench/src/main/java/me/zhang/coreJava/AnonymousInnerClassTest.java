package me.zhang.coreJava;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhang on 2017/10/17 17:11.
 */
public class AnonymousInnerClassTest {

    public static void main(String[] args) {
        List<String> friends = new ArrayList<String>() {
            // object initialization block
            {
                // double brace initializaiton
                add("Lucy");
                add("Lily");
                add("Black");
            }
        };
        System.out.println(friends);
    }

}
