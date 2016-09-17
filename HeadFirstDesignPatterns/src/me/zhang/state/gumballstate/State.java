package me.zhang.state.gumballstate;

/**
 * Created by Zhang on 12/6/2015 1:27 下午.
 */
public interface State {
    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();
}
