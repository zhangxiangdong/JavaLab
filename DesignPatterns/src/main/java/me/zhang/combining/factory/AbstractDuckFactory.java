package me.zhang.combining.factory;

import me.zhang.combining.Quackable;

/**
 * Created by Li on 1/24/2016 2:27 PM.
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createMallardDuck();

    public abstract Quackable createRedheadDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createRubberDuck();

    public abstract Quackable createDecoyDuck();
}
