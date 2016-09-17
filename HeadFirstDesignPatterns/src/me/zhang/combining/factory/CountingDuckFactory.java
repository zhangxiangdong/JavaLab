package me.zhang.combining.factory;

import me.zhang.combining.Quackable;
import me.zhang.combining.decorator.QuackCounter;

/**
 * Created by Li on 1/24/2016 2:30 PM.
 */
public class CountingDuckFactory extends AbstractDuckFactory {

    AbstractDuckFactory duckFactory;

    public CountingDuckFactory(AbstractDuckFactory duckFactory) {
        this.duckFactory = duckFactory;
    }

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(duckFactory.createMallardDuck());
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(duckFactory.createRedheadDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(duckFactory.createDuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(duckFactory.createRubberDuck());
    }

    @Override
    public Quackable createDecoyDuck() {
        return new QuackCounter(duckFactory.createDecoyDuck());
    }
}
