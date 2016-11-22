package me.zhang.combining.composite;

import me.zhang.combining.Quackable;
import me.zhang.combining.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Li on 1/24/2016 3:09 PM.
 */
public class Flock implements Quackable {

    List<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        // 迭代器模式
//        Iterator<Quackable> iterator = quackers.iterator();
//        while (iterator.hasNext()) {
//            Quackable quacker = iterator.next();
//            quacker.quack();
//        }
        for (Quackable quacker : quackers) {
            quacker.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        // 为组合中所有的observable注册observer
        for (Quackable duck : quackers) {
            duck.registerObserver(observer);
        }
    }

    @Override
    public void notifyObservers() {
//        for (Quackable duck : quackers) {
//            duck.notifyObservers();
//        }
    }

    @Override
    public String toString() {
        return "Flock of Ducks";
    }
}
