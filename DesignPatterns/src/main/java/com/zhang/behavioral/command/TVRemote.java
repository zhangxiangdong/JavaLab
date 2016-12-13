package com.zhang.behavioral.command;

/**
 * Created by Zhang on 12/13/2016 10:06 PM.
 */
public class TVRemote {

    public static ElectronicDevice getDevice() {
        return new Television();
    }

}
