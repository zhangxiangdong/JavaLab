package me.zhang.combining.factory;

import me.zhang.combining.Goose;

/**
 * Created by Li on 1/24/2016 2:42 PM.
 */
public class GooseFactory extends AbstractGooseFactory {
    @Override
    public Honkable createGoose() {
        return new Goose();
    }
}
