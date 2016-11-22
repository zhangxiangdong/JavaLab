package me.zhang.proxy.gumball;

import java.io.Serializable;

/**
 * Created by Zhang on 12/6/2015 1:27 下午.
 */
public interface State extends Serializable {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
