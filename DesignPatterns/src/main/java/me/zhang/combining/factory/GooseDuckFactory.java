package me.zhang.combining.factory;

import me.zhang.combining.Quackable;

/**
 * Created by Li on 1/24/2016 2:45 PM.
 */
public class GooseDuckFactory {

    AbstractGooseFactory gooseFactory;

    public GooseDuckFactory(AbstractGooseFactory gooseFactory) {
        this.gooseFactory = gooseFactory;
    }

    // FIXME: 1/24/2016 待定
    public Quackable createGoose() {
        Honkable goose = gooseFactory.createGoose();
        return new GooseDuckAdapter(goose);
    }
}
