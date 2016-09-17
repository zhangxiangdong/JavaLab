package me.zhang.combining;

import me.zhang.combining.composite.Flock;
import me.zhang.combining.decorator.QuackCounter;
import me.zhang.combining.factory.*;
import me.zhang.combining.observer.Quackologist;

/**
 * Created by Li on 1/24/2016 1:45 PM.
 */
public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }

    private void simulate() {
        AbstractDuckFactory duckFactory = new DuckFactory(); // Duck Factory
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory(duckFactory); // Counting Duck Factory
        Quackable redheadDuck = countingDuckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();
        Quackable decoyDuck = countingDuckFactory.createDecoyDuck();

        AbstractGooseFactory gooseFactory = new GooseFactory();
        GooseDuckFactory gooseDuckFactory = new GooseDuckFactory(gooseFactory);
        Quackable gooseDuck = gooseDuckFactory.createGoose(); // 不需要计数装饰

        System.out.println("\nDuck Simulator: With Composite - Flocks");

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(decoyDuck);
        flockOfDucks.add(gooseDuck);

        Flock flockOfMallards = new Flock();
        Quackable mallardDuckOne = countingDuckFactory.createMallardDuck();
        Quackable mallardDuckTwo = countingDuckFactory.createMallardDuck();
        Quackable mallardDuckThree = countingDuckFactory.createMallardDuck();
        flockOfMallards.add(mallardDuckOne);
        flockOfMallards.add(mallardDuckTwo);
        flockOfMallards.add(mallardDuckThree);

        // 将Mallards加入Ducks
        flockOfDucks.add(flockOfMallards);

        Quackologist quackologist = new Quackologist(); // 观察者
        /**
         * quackologist观察Whole Flock
         */
        flockOfDucks.registerObserver(quackologist);

        System.out.println("\n*** Duck Simulator: Whole Flock Simulation ***");
        simulate(flockOfDucks);

//        System.out.println("\nDuck Simulator: Mallard Flock Simulation");
//        simulate(flockOfMallards);

        System.out.println("\nNumber of quacks: " + QuackCounter.getNumOfQuacks());

    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}
